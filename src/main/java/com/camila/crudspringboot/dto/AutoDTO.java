package com.camila.crudspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AutoDTO(String id, @NotBlank String make_brand, @NotBlank String model, @NotNull Integer price_in_cents) {
}
