package com.ecom.prodcutservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionsDto {
    private String message;
    private int code;

    public ExceptionsDto(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
