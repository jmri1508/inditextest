package com.inditex.zara.adapters.inbound.rest.mapper;

import com.inditex.zara.adapters.inbound.rest.response.PriceResponse;
import com.inditex.zara.entity.PriceView;
import org.mapstruct.Mapper;

/** PriceRestInboundMapper */
@Mapper(componentModel = "spring")
public interface PriceRestInboundMapper {
    PriceResponse priceViewToPriceResponse(PriceView price);

}
