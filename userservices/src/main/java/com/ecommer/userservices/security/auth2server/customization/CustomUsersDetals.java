package com.ecommer.userservices.security.auth2server.customization;

import com.ecommer.userservices.entity.Roles;
import com.ecommer.userservices.entity.Users;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@JsonDeserialize// json deserializer requirment of springboot oauth2 implentation
//@NoArgsConstructor// no argument constructor
public class CustomUsersDetals implements UserDetails {
    private String password;// user custome password for jwt token  implementation
    private  String username;// user custome user for jwt token  implementation
    private long userId;// user custome user id for jwt token implementation
    private boolean accountNonExpired;// user custome jwt token expiry for jwt implementation
    private  boolean accountNonLocked;// user custome jwt token credential lock for jwt implementation
    private  boolean credentialsNonExpired;// // user custome jwt token credential non expiry for jwt implementation
    private boolean enabled;// // user custome jwt token enable for jwt implementation
    private String userEmail;// optional // user custome jwt token usereamil for jwt not implementation
    private List<GrantedAuthority>authorities;

    public CustomUsersDetals() {
    }

    //// user custome jwt token role based authority for jwt implementation

// setters
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    @Override
    public String getUsername() {
        return username;
    }

    public CustomUsersDetals(Users user) {// converting user to custom user
        this.username = user.getUserEmail();
        this.password = user.getUserPassword();
        this.userId=user.getUserId();
        this.userEmail = user.getUserEmail();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.authorities = user.getRolesList().stream()
                .map(role -> new CustomiseGrandAuthority( role.getRoleType())) //  role format as string
                .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
// getters
    public String getUserEmail() {
        return username;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
