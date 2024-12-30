package com.inditex.zara.ports;


import com.inditex.zara.entity.PriceView;
import com.inditex.zara.exception.PriceNotFoundException;
import com.inditex.zara.query.FindPricesQuery;

import java.util.Optional;

/** PriceRepositoryRepositoryPort */
public interface PriceRepositoryPort {

    Optional<PriceView> findPriceByParameters(final FindPricesQuery query) throws PriceNotFoundException;

}
