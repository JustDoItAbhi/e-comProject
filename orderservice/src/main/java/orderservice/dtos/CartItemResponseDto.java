package orderservice.dtos;

import lombok.Data;

@Data
public class CartItemResponseDto {
    private long cartId;
    private long productId;
    private String productName;
    private int quantity;
    private double price;
}
