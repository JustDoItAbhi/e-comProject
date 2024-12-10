package cartservice.controller;

import cartservice.entity.UserDetails;
import cartservice.service.UserServices;
import cartservice.userdtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartUser")
public class UserController {
    @Autowired
    private UserServices userServices;
    @GetMapping("/getUserByid/{email}")
    public ResponseEntity<UserDetails> getByiD(@PathVariable("email")String email) {
        return ResponseEntity.ok(userServices.createUser(email));
    }
}
