package com.example.project3.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "id should not be null")
    private Integer id;
    @NotNull(message = "product id should not be null")
    private Integer productId;
    @NotNull(message = "merchant id should not be null")
    private Integer merchantId;
    @Value("10")
    private Integer stock;
}
