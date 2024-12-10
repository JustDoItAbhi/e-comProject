//package cartservice.client;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.HttpStatus;
//
//@Service
//public class TokenService {
//
//    @Value("${auth.server.token.url}")
//    private String tokenUrl; // e.g., http://localhost:8080/oauth/token
//
//    @Value("${auth.server.client.id}")
//    private String clientId;
//
//    @Value("${auth.server.client.secret}")
//    private String clientSecret;
//
//    @Value("${auth.server.username}")
//    private String username;
//
//    @Value("${auth.server.password}")
//    private String password;
//
//    private final RestTemplate restTemplate;
//
//    public TokenService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public String getAuthToken() {
//        // Build the request body
//        String requestBody = String.format(
//                "grant_type=password&username=%s&password=%s&client_id=%s&client_secret=%s",
//                username, password, clientId, clientSecret
//        );
//        System.out.println(requestBody);
//
//        // Set headers
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "application/x-www-form-urlencoded");
//
//        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//
//        try {
//            // Make the request to get the token
//            ResponseEntity<TokenResponse> response = restTemplate.exchange(
//                    tokenUrl,
//                    HttpMethod.GET,
//                    entity,
//                    TokenResponse.class
//            );
//
//            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
//                return response.getBody().getAccessToken(); // Extract the token
//            } else {
//                throw new RuntimeException("Failed to retrieve token: " + response.getStatusCode());
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Error while retrieving token: " + e.getMessage(), e);
//        }
//    }
//
//    // Helper class to parse the response
//    static class TokenResponse {
//        private String access_token;
//
//        public String getAccessToken() {
//            return access_token;
//        }
//
//        public void setAccessToken(String access_token) {
//            this.access_token = access_token;
//        }
//    }
//}
//
