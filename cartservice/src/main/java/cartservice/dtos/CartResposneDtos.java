package cartservice.dtos;

import cartservice.entity.CartItems;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CartResposneDtos {
    private String userId;
    private List<CartItemResponseDto> items = new ArrayList<>();
    private double total;
}
