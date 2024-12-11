package cartservice.controller;

import cartservice.dtos.*;
import cartservice.entity.UserDetails;
import cartservice.service.IcartServices;
import cartservice.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IcartServices icartServices;

    @Autowired
    private UserServices userServices;
    @GetMapping("/login/{userID}")
    public ResponseEntity<UserDetails> getByiD(@PathVariable("userID")String userID) {
        return ResponseEntity.ok(userServices.createUser(userID));
    }

    @PostMapping("/add")
    public ResponseEntity<CartResposneDtos> getItams(@RequestBody CartRequestDto dtos) {
        return ResponseEntity.ok(icartServices.addItemToCart(dtos));
    }

    @DeleteMapping("/userdelete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") long id) {
        return ResponseEntity.ok(icartServices.deleteUser(id));
    }

    @GetMapping("/getByid/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(icartServices.getByIds(id));
    }

    @DeleteMapping("/deleteCart/userId/{userId}/productId/{productId}")
    public ResponseEntity<CartResposneDtos> removeCart(@PathVariable("userId") String userId, @PathVariable("productId")long productId) {
        return ResponseEntity.ok(icartServices.removeItemFromCart(userId,productId));
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<CartResposneDtos> deleteUser(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(icartServices.confirmCart(userId));
    }
}
