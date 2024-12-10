package cartservice.configrations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestClient;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                    .csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers("/cart/add").permitAll()
                                .requestMatchers("/cart/getByid/id").permitAll()
//                                    .requestMatchers(  "/category/id").hasAuthority("USER")

                                .anyRequest().authenticated()// prohabited all other functions
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter()))// implementing jwt
                );

        return http.build();
    }


}
