package com.ecommer.userservices.users.usercontroller;

import com.ecommer.userservices.users.userdtos.LogOut;
import com.ecommer.userservices.users.userdtos.Login;
import com.ecommer.userservices.users.userdtos.SignUp;
import com.ecommer.userservices.users.userdtos.UserResponseDto;
import com.ecommer.userservices.users.userservices.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody SignUp signUp) throws JsonProcessingException {
        return ResponseEntity.ok(userServices.signUp(signUp));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody Login login) {
        return ResponseEntity.ok(userServices.logIn(login));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
        if (!userServices.deleteUser(id)) {
            return ResponseEntity.badRequest().body(new MessageResponse("id cannot be deleted"));
        } else {
            userServices.deleteUser(id);
            return ResponseEntity.ok(new MessageResponse("id deleted"));
        }
    }
    @GetMapping("/logout/{email}")
    public ResponseEntity<UserResponseDto> logout(@RequestBody LogOut logOut){
        return new ResponseEntity<>(userServices.logOut(logOut), HttpStatus.OK);
    }
    @GetMapping("/getUserByid/{email}")
    public ResponseEntity<UserResponseDto> getByiD(@PathVariable ("email")String email) {
        return ResponseEntity.ok(userServices.getById(email));
    }
    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> getByiD() {
        return ResponseEntity.ok(userServices.getAllUsers());
    }


}
