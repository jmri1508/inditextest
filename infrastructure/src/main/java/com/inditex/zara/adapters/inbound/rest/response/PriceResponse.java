package com.inditex.zara.adapters.inbound.rest.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 6614625720869112381L;

    @Schema(
            name = "productId",
            description = "The product Identifier",
            example = "1"
    )
    @Positive(message = "zara.validators.productId.positive")
    private Long productId;

    @Schema(
            name = "brandId",
            description = "The brand Identifier",
            example = "1"
    )
    @Positive(message = "zara.validators.brandId.positive")
    private Long brandId;

    @Schema(
            name = "priceList",
            description = "The price list Identifier",
            example = "1"
    )
    @Positive(message = "zara.validators.priceList.positive")
    private Long priceList;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    @Positive(message = "zara.validators.price.positive")
    private Double price;


}
