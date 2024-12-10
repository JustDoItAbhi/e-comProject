package cartservice.configrations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestClient;

@Configuration
public class WebClient {

    @Bean(name = "userServiceRestClient")
    public RestClient userServiceRestClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:8090/user/")
                .build();
    }
    @Bean(name="productServiceRestClient")
    public RestClient productServiceRestClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:8080/product")
                .build();
    }
}



