package com.inditex.zara.adapters.outbound.persistence.h2.mapper;

import com.inditex.zara.adapters.outbound.persistence.h2.entity.PriceEntity;
import com.inditex.zara.entity.PriceView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/** H2QueryMapper */
@Mapper(componentModel = "spring")
public interface H2QueryMapper {

    @Mapping(target = "brandId", source = "brand.id")
    PriceView toPriceView(PriceEntity entity);

}
