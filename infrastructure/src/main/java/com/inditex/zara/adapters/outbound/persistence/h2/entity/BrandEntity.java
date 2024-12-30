package com.inditex.zara.adapters.outbound.persistence.h2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** BrandEntity */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "BrandEntity")
@Table(name = "BRANDS")
public class BrandEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;
}
