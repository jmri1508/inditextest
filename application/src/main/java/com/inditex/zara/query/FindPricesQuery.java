package com.inditex.zara.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/** FindProductQuery */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindPricesQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 6527219682576711564L;

    private Long productId;

    private Long brandId;

    private LocalDateTime priceDate;

}
