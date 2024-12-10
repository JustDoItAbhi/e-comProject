package cartservice.service;

import cartservice.dtos.ProductResponseDto;
import cartservice.entity.UserDetails;
import cartservice.mapper.UserMapper;
import cartservice.repository.UserDetailsReposirtoy;
import cartservice.userdtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserDetailsReposirtoy userDetailsReposirtoy;
    @Autowired
    @Qualifier( "userServiceRestClient")
    private RestClient restClient;
    @Override
    public UserDetails createUser(String email) {

        // Fetch user data from the user service
        UserResponseDto responseDto = restClient.get()
                .uri("/getUserByid/" + email)
                .retrieve()
                .body(UserResponseDto.class);

        // Map the response to UserDetails
        UserDetails details = UserMapper.fromEntity(responseDto);

        // Save the mapped entity to the repository
        userDetailsReposirtoy.save(details);

        return details;
    }

    @Override
    public boolean deleteUser(long id) {
        return false;
    }
}
