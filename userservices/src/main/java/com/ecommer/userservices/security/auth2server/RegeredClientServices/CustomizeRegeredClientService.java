package com.ecommer.userservices.security.auth2server.RegeredClientServices;

import com.ecommer.userservices.security.auth2server.dtos.ClientRequestDto;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

public interface CustomizeRegeredClientService {
    RegisteredClient createRegeretedClient(ClientRequestDto dto);
}
