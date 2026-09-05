package edu.learningspringboot.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class UpdateProductPrice {
    @NotNull
    @DecimalMin(value ="1.0", message="Price must be >= 1")
    @Digits(integer=8,fraction = 2)
    private BigDecimal price;
}
