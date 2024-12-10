package com.ecommer.userservices.security.auth2server.RegeredClientServices;

import com.ecommer.userservices.security.auth2server.authservices.JpaRegisteredClientRepository;
import com.ecommer.userservices.security.auth2server.dtos.ClientRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class CustomizeRegeredClientServiceImpl implements CustomizeRegeredClientService{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JpaRegisteredClientRepository jpaRegisteredClientRepository;
    @Override
    public RegisteredClient createRegeretedClient(ClientRequestDto dto) {
        Set<AuthorizationGrantType>authorizationGrantTypes=new HashSet<>();
        authorizationGrantTypes.add(AuthorizationGrantType.AUTHORIZATION_CODE);
        authorizationGrantTypes.add(AuthorizationGrantType.REFRESH_TOKEN);
        authorizationGrantTypes.add(AuthorizationGrantType.CLIENT_CREDENTIALS);
        authorizationGrantTypes.add(AuthorizationGrantType.DEVICE_CODE);
        authorizationGrantTypes.add(AuthorizationGrantType.JWT_BEARER);
        authorizationGrantTypes.add(AuthorizationGrantType.TOKEN_EXCHANGE);

        Set<String> scopes=new HashSet<>();
        scopes.add(OidcScopes.PROFILE);
        scopes.add(OidcScopes.OPENID);
        scopes.add(OidcScopes.ADDRESS);
        scopes.add(OidcScopes.EMAIL);
        scopes.add(OidcScopes.PHONE);

        RegisteredClient.Builder oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
                    .clientId(dto.getClientId())
                    .clientSecret(passwordEncoder.encode(dto.getClientSecret()))
                    .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                    .redirectUri(dto.getRedirectUris())
                    .clientName(dto.getClientName())
                .clientIdIssuedAt(Instant.now())
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                    .postLogoutRedirectUri(dto.getPostLogoutRedirectUris())
                    .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build());
        for (AuthorizationGrantType grandType:authorizationGrantTypes){
            oidcClient.authorizationGrantType(grandType);
        }
//        for (String scope:scopes){
//            oidcClient.scope(scope);
//        }
        RegisteredClient client=oidcClient.build();
        jpaRegisteredClientRepository.save(client);
        return client;
    }
}
