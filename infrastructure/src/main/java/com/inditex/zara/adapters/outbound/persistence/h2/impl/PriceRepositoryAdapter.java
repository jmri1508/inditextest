package com.inditex.zara.adapters.outbound.persistence.h2.impl;

import com.inditex.zara.adapters.outbound.persistence.h2.entity.PriceEntity;
import com.inditex.zara.adapters.outbound.persistence.h2.mapper.H2QueryMapper;
import com.inditex.zara.adapters.outbound.persistence.h2.repository.PriceRepository;
import com.inditex.zara.configuration.ResponsesConfiguration;
import com.inditex.zara.entity.PriceView;
import com.inditex.zara.exception.PriceNotFoundException;
import com.inditex.zara.ports.PriceRepositoryPort;
import com.inditex.zara.query.FindPricesQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/** PriceRepositoryAdapter */

@Slf4j
@Component
@AllArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final H2QueryMapper mapper;
    private final PriceRepository repository;

    @Override
    public Optional<PriceView> findPriceByParameters(FindPricesQuery query) throws PriceNotFoundException {

        if(log.isInfoEnabled()){
            log.info("[start] - PriceRepositoryAdapter.findAll - productId '{}'. " +
                    "brandId '{}'. priceDate '{}'.", query.getProductId(), query.getBrandId(), query.getPriceDate());
        }

        PriceEntity response = repository.findPrice(
                query.getProductId(),
                query.getBrandId(),
                query.getPriceDate())
                .orElseThrow(() -> new PriceNotFoundException(ResponsesConfiguration.RESPONSE_404));


        if(log.isInfoEnabled()){
            log.info("[end] - PriceRepositoryAdapter.findAll - productId '{}'. " +
                            "brandId '{}'. priceDate '{}'. response '{}'.",
                    query.getProductId(),
                    query.getBrandId(),
                    query.getPriceDate(),
                    response);
        }
        return Optional.of(mapper.toPriceView(response));
    }
}
