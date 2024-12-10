package com.ecommer.userservices.roles.roledtos;

import lombok.Data;

import java.util.Set;

@Data
public class RegisterOidcClientRequestDto {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String postLogoutRedirectUri;
    private boolean requireAuthorizationConsent;
    private Set<String> scopes;
}
