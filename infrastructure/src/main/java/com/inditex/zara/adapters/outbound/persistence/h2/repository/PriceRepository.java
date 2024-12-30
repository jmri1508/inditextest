package com.inditex.zara.adapters.outbound.persistence.h2.repository;

import com.inditex.zara.adapters.outbound.persistence.h2.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/** PriceRepository */
@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, UUID> {

    @Query("SELECT p FROM PriceEntity p " +
            "            WHERE p.productId = :productId " +
            "            AND p.brand.id = :brandId " +
            "            AND :priceDate BETWEEN p.startDate AND p.endDate " +
            "            ORDER BY p.priority DESC " +
            "            LIMIT 1")
    Optional<PriceEntity> findPrice(@Param("productId") Long productId,
                                    @Param("brandId") Long brandId,
                                    @Param("priceDate") LocalDateTime priceDate);
}
