package cartservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private long id;
    private String name;
    private String description;
    private String brand ;
    private int price;
    private int  stock;
    private String image;
}
