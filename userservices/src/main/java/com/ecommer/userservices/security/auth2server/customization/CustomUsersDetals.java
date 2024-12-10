package com.ecommer.userservices.security.auth2server.customization;

import com.ecommer.userservices.entity.Roles;
import com.ecommer.userservices.entity.Users;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@JsonDeserialize
@NoArgsConstructor
public class CustomUsersDetals implements UserDetails {
//    private Users user;
    private String password;
    private  String username;
    private boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private boolean enabled;
    private List<GrantedAuthority>authorities;
    private String userName;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CustomUsersDetals(Users user) {
//        this.username = user.getUserName();
        this.password = user.getUserPassword();
        this.username = user.getUserEmail();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.userName =user.getUserName();
        authorities=new ArrayList<>();

        // Check if roles are null or empty
        if (user.getRolesList() != null && !user.getRolesList().isEmpty()) {
            for (Roles roles1 : user.getRolesList()) {
                System.out.println("Adding role: " + roles1.getRoleType());
                authorities.add(new CustomiseGrandAuthority(roles1));
            }
        } else {
            System.out.println("No roles assigned to user: " + user.getUserName());
        }


    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String getUsername() {
        return username;
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
