package cartservice.userdtos;

import cartservice.entity.UserDetails;
import cartservice.mapper.UserMapper;
import cartservice.repository.UserDetailsReposirtoy;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Service
public class UserclientRestTemplate {
    @Autowired
    private UserDetailsReposirtoy reposirtoy;
    @Autowired
    @Qualifier("userServiceRestClient")
    private RestClient restClient;

    public UserDetails fetchUser(String userEmail, String jwtToken){
        UserResponseDto responseDto=new UserResponseDto();
        responseDto=restClient.get()
                .uri("/getUserByid/"+userEmail)
                .headers(headers -> headers.setBearerAuth(jwtToken)) // Set Bearer Token // storing token in header
                .retrieve()
                .body(UserResponseDto.class);
        UserDetails userDetails=new UserDetails();
        userDetails.setUserId(responseDto.getUserId());
        userDetails.setUserPhone(responseDto.getUserPhone());
        userDetails.setUserEmail(responseDto.getUserEmail());
        userDetails.setUserName(responseDto.getUserName());
//        reposirtoy.save(userDetails);
        return UserMapper.fromEntity(responseDto);

    }
    private String getJwtToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken) {
            JwtAuthenticationToken jwtAuth = (JwtAuthenticationToken) authentication;
            return jwtAuth.getToken().getTokenValue();
        }
        throw new IllegalStateException("JWT token is not available");
    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
        System.out.println("ENTERED BY CART SERVICE");
    }
}
