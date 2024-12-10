package com.ecommer.userservices.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@MappedSuperclass
public abstract class BaseModels {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    public long getId() {
        return id;
    }
}
