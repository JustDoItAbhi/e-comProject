package com.ecommer.userservices.roles.roledtos;

import com.ecommer.userservices.entity.Roles;
import com.ecommer.userservices.entity.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RoleResponseDto {
    private long roleId;
    private String role;
    private Users users;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public static RoleResponseDto fromEntity(Roles roles){
        RoleResponseDto responseDto=new RoleResponseDto();
        responseDto.setRoleId(roles.getId());
        responseDto.setRole(roles.getRoleType());
        responseDto.setUsers(responseDto.getUsers());
        return responseDto;
    }
}
