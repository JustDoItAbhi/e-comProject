package cartservice.controller;

import cartservice.dtos.CartItemResponseDto;
import cartservice.dtos.CartRequestDto;
import cartservice.dtos.CartResposneDtos;
import cartservice.dtos.ProductResponseDto;
import cartservice.service.IcartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IcartServices icartServices;

//    @GetMapping("/{userid}")
//    public ResponseEntity<String> getCart(@PathVariable("userid") String userid) {
//        return ResponseEntity.ok(icartServices.getCart(userid));
//    }

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

    @DeleteMapping("/deleteCart/{email}/{productId}")
    public ResponseEntity<CartItemResponseDto> remoceCart(@PathVariable("email") String userId, @PathVariable long productId) {
        return ResponseEntity.ok(icartServices.removeItemFromCart(userId, productId));
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<CartResposneDtos> deleteUser(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(icartServices.confirmCart(userId));
    }
}
