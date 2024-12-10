package cartservice.entity;

import cartservice.dtos.ProductResponseDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CartItems extends BaseModels{
    private long productId;
    private String productName;
    private int quantity;
    private double price;

    public CartItems() {
    }

    public CartItems(long productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
