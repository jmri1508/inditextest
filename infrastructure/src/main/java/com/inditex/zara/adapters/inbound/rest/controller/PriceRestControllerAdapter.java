package com.inditex.zara.adapters.inbound.rest.controller;

import com.inditex.zara.configuration.ApiResponseConfiguration;
import com.inditex.zara.configuration.ResponsesConfiguration;
import com.inditex.zara.entity.RestErrorEntity;
import com.inditex.zara.exception.PriceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

/** PriceRestControllerAdapter */
@Validated
@RequestMapping(value = "${api.endpoints.price.mapping}")
@Tag(
        name = "prices",
        description = "Prices API"
)
public interface PriceRestControllerAdapter {

    @Operation(
            description = "Obtain the list of prices",
            responses = {
                    @ApiResponse(
                            responseCode = ApiResponseConfiguration.RESPONSE_200_CODE,
                            description = ApiResponseConfiguration.RESPONSE_200),
                    @ApiResponse(
                            responseCode = "400",
                            description = ResponsesConfiguration.RESPONSE_400,
                            content = @Content(schema = @Schema(implementation = RestErrorEntity.class))),
                    @ApiResponse(
                            responseCode = "500",
                            description = ResponsesConfiguration.RESPONSE_500,
                            content = @Content(schema = @Schema(implementation = RestErrorEntity.class)))
            })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> findPrice(
            @Parameter(name = "productId", description = "productId", in = ParameterIn.QUERY)
            @RequestParam(value = "productId")
            @Positive(message = "zara.validators.productId.positive")
            @Valid Long productId,
            @Parameter(name = "brandId", description = "brandId", in = ParameterIn.QUERY)
            @RequestParam(value = "brandId")
            @Positive(message = "zara.validators.brandId.positive")
            @Valid Long brandId,
            @Parameter(name = "priceDate", description = "priceDate", in = ParameterIn.QUERY)
            @RequestParam(value = "priceDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            @Valid LocalDateTime priceDate) throws PriceNotFoundException;


}
