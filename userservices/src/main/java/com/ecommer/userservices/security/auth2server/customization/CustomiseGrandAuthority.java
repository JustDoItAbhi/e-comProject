package com.ecommer.userservices.security.auth2server.customization;

import com.ecommer.userservices.entity.Roles;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@JsonDeserialize// json deserialization annotation its requirment of spring boot oauth2 server
@NoArgsConstructor// no argument constructor its requirment of spring boot oauth2 server
public class CustomiseGrandAuthority implements GrantedAuthority {
    @JsonProperty("authority")// specified json property
    private String grantAuthority;
    public CustomiseGrandAuthority(String roles) {// constructor for role base authentication its string as my role is of string type
        System.out.println("ROLE IS HERE _-----------------"+ roles);// log
        this.grantAuthority = roles;
    }
    @Override
    public String getAuthority() {// return authority
        return this.grantAuthority;
    }
}
