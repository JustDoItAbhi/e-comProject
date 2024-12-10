package cartservice.service;

import cartservice.dtos.CartItemResponseDto;
import cartservice.dtos.CartRequestDto;
import cartservice.dtos.CartResposneDtos;
import cartservice.dtos.ProductResponseDto;
import cartservice.entity.UserDetails;

public interface IcartServices {
//    UserDetails getCart(String userID);
    CartResposneDtos addItemToCart(CartRequestDto dto);
    CartItemResponseDto removeItemFromCart(String userId, long productID);
    CartResposneDtos confirmCart(String userId);
    boolean deleteUser(long id);
    CartResposneDtos getById(long id);
    ProductResponseDto getByIds(long id);

}

