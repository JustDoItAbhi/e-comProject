package com.ecommer.userservices.users.userservices;

import com.ecommer.userservices.users.userdtos.LogOut;
import com.ecommer.userservices.users.userdtos.Login;
import com.ecommer.userservices.users.userdtos.SignUp;
import com.ecommer.userservices.users.userdtos.UserResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface UserServices {
    UserResponseDto signUp(SignUp signUp) throws JsonProcessingException;
    UserResponseDto logIn(Login login);
    UserResponseDto logOut(LogOut logOut);
    List<UserResponseDto>getAllUsers();
    boolean deleteUser(long id);
    UserResponseDto getById(String email);
}
