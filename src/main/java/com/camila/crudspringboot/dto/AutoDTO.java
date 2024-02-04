package com.camila.crudspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AutoDTO(String id, @NotBlank String brand, @NotBlank String model, @NotNull Integer price_in_cents) {
    public static class ExceptionDTO {
    }
}
