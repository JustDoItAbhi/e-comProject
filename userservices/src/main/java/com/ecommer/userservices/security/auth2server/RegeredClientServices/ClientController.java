package com.ecommer.userservices.security.auth2server.RegeredClientServices;

import com.ecommer.userservices.security.auth2server.dtos.ClientRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    public CustomizeRegeredClientService service;
    @PostMapping("/register")
    public ResponseEntity<RegisteredClient> createClient(@RequestBody ClientRequestDto dto){
        return ResponseEntity.ok(service.createRegeretedClient(dto));
    }
}
