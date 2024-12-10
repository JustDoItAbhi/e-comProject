package com.ecom.prodcutservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Categoryes extends BaseModels {
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "category_description")
    private String categoryDescription;
    @OneToMany(mappedBy = "categoryes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Products> products;

}