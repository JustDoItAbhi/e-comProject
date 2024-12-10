package com.ecom.prodcutservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

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
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Categoryes categoryes;
}
