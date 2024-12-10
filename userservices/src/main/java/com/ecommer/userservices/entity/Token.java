package com.ecommer.userservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Entity
@Table(name="TOKEN")
public class Token extends BaseModels{
    private String tokenId;
    @OneToOne
    private Users users;
    @OneToOne
    private Roles roles;
}
