package com.ecom.prodcutservice.product.dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private String description;
    private String brand;
    private int price;
    private int  stock;
    private String image;
    private long categoryesId;
}
