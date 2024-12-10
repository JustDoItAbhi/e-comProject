package com.ecom.prodcutservice.product.dtos;

import com.ecom.prodcutservice.entity.Categoryes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private long id;
    private String name;
    private String description;
    private String brand ;
    private int price;
    private int  stock;
    private String image;
    private Categoryes categoryes;
}
