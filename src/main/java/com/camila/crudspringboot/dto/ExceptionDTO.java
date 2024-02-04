package com.camila.crudspringboot.dto;

import lombok.NoArgsConstructor;

public class ExceptionDTO {

    String message;
    Integer status;

    public ExceptionDTO(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
