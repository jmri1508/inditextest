package com.inditex.zara.adapters.outbound.persistence.h2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/** PriceEntity */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PriceEntity")
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @Column(name = "ID")
    private UUID id;

    @Positive(message = "zara.validators.productId.positive")
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID")
    private BrandEntity brand;

    @Positive(message = "zara.validators.priceList.positive")
    @Column(name = "PRICE_LIST")
    private Long priceList;

    @NotNull
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Positive(message = "zara.validators.price.positive")
    @Column(name = "PRICE")
    private Double price;

    @NotNull
    @Column(name = "PRIORITY")
    private Long priority;

    @NotNull
    @Column(name = "CURRENCY")
    @Size(min = 3, max = 3)
    private String currency;

}
