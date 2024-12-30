package com.inditex.zara.service;


import com.inditex.zara.entity.PriceView;
import com.inditex.zara.exception.PriceNotFoundException;
import com.inditex.zara.ports.GetPricesUseCaseServicePort;
import com.inditex.zara.ports.PriceRepositoryPort;
import com.inditex.zara.query.FindPricesQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/** GetPricesUseCaseServiceImpl */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class GetPricesUseCaseServiceImpl implements GetPricesUseCaseServicePort {

    private final PriceRepositoryPort priceRepository;

    @Override
    public PriceView execute(FindPricesQuery query) throws PriceNotFoundException {

        if(log.isInfoEnabled()){
            log.info("[start] - GetPricesUseCaseServiceImpl.execute - productId '{}'. " +
                    "brandId '{}'. priceDate '{}'.", query.getProductId(), query.getBrandId(), query.getPriceDate());
        }

        PriceView response = priceRepository.findPriceByParameters(query)
                .orElseThrow(() -> new PriceNotFoundException("Price not found for this parameters."));


        if(log.isInfoEnabled()){
            log.info("[end] - GetPricesUseCaseServiceImpl.execute - productId '{}'. " +
                    "brandId '{}'. priceDate '{}'. response '{}'.",
                    query.getProductId(),
                    query.getBrandId(),
                    query.getPriceDate(),
                    response);
        }

        return response;

    }
}
