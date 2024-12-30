package com.inditex.zara.ports;


import com.inditex.zara.entity.PriceView;
import com.inditex.zara.exception.PriceNotFoundException;
import com.inditex.zara.query.FindPricesQuery;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/** GetPricesUseCaseServicePort */
@Validated
public interface GetPricesUseCaseServicePort {

    PriceView execute(@Valid @NotNull final FindPricesQuery query) throws PriceNotFoundException;
}
