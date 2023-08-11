package com.example.project3.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotNull(message = "id should not be null")
    private Integer id;

    @NotEmpty(message = "name should not be null")
    @Size(min = 3)
    private String name;

    @NotNull(message = "price should not be null ")
    @Positive
    private Integer price;

    @NotNull(message = "category should not be null")
    private Integer categoryId;
}
