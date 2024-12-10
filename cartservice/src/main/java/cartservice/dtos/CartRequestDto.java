package cartservice.dtos;

import cartservice.entity.CartItems;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CartRequestDto {
    private String userId;
    private List<CartItems> item = new ArrayList<>();
    private double totalprices;
}
