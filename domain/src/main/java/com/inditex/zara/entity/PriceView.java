package com.inditex.zara.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/** PriceView */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceView implements Serializable {
    @Serial
    private static final long serialVersionUID = -2025714347390447748L;

    private UUID id;

    @Positive(message = "zara.validators.productId.positive")
    private Long productId;

    @Positive(message = "zara.validators.brandId.positive")
    private Long brandId;

    @Positive(message = "zara.validators.priceList.positive")
    private Long priceList;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    @Positive(message = "zara.validators.price.positive")
    private Double price;

    @NotNull
    private Long priority;

    @NotNull
    private String currency;

}
