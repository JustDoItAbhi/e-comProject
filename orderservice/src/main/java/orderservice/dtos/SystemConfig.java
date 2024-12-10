package orderservice.dtos;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

public class SystemConfig {
    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:8085/cart/getByid/")
                .build();
    }
}
