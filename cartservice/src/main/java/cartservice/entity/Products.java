package cartservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Products")
public class Products extends BaseModels {
   private String name;
    private String description;
    private String Brand ;
   private int Price;
   private int  Stock;
    private String image;
}
