package com.inditex.zara.adapters.inbound.rest.controller.impl;

import com.inditex.zara.adapters.inbound.rest.controller.PriceRestControllerAdapter;
import com.inditex.zara.adapters.inbound.rest.mapper.PriceRestInboundMapper;
import com.inditex.zara.adapters.inbound.rest.response.PriceResponse;
import com.inditex.zara.exception.PriceNotFoundException;
import com.inditex.zara.ports.GetPricesUseCaseServicePort;
import com.inditex.zara.query.FindPricesQuery;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/** PriceRestControllerAdapterImpl */
@RestController
@RequiredArgsConstructor
@Slf4j
public class PriceRestControllerAdapterImpl implements PriceRestControllerAdapter {

    private final PriceRestInboundMapper priceRestInboundMapper;
    private final GetPricesUseCaseServicePort getPricesUseCaseService;

    @Override
    public ResponseEntity<?> findPrice(
            Long productId,
            Long brandId,
            LocalDateTime priceDate) throws PriceNotFoundException {

        if(log.isInfoEnabled()){
            log.info("[start] - PriceRestControllerAdapterImpl.findPrices - productId '{}'. " +
                    "brandId '{}'. priceDate '{}'.", productId, brandId, priceDate);
        }

        final FindPricesQuery query = FindPricesQuery.builder()
                .productId(productId)
                .brandId(brandId)
                .priceDate(priceDate)
                .build();

        var price = this.priceRestInboundMapper.priceViewToPriceResponse(
                getPricesUseCaseService.execute(query));

        var responseEntity = getPriceResponse(price);

        if(log.isInfoEnabled()){
            log.info("[end] - PriceRestControllerAdapterImpl.findPrices - productId '{}'. " +
                    "brandId '{}'. priceDate '{}'. response '{}'.", productId, brandId, priceDate, responseEntity);
        }

        return responseEntity;
    }

    private ResponseEntity getPriceResponse(PriceResponse responseEntity){
        HttpHeaders responseListHeaders = this.addResponseHeaders(new HttpHeaders());
        return (ResponseEntity.ok().headers(responseListHeaders)).body(responseEntity);
    }

    private HttpHeaders addResponseHeaders(@Valid @NotNull HttpHeaders responseHeaders) {
        responseHeaders.add("Cache-Control", "no store, private, max-age=0");
        responseHeaders.add("Content-Type", "application/json");
        return responseHeaders;
    }


}
