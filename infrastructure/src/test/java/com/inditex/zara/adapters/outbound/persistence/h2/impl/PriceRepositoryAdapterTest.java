package com.inditex.zara.adapters.outbound.persistence.h2.impl;

import com.inditex.zara.adapters.outbound.persistence.h2.entity.BrandEntity;
import com.inditex.zara.adapters.outbound.persistence.h2.entity.PriceEntity;
import com.inditex.zara.adapters.outbound.persistence.h2.mapper.H2QueryMapper;
import com.inditex.zara.adapters.outbound.persistence.h2.mapper.H2QueryMapperImpl;
import com.inditex.zara.adapters.outbound.persistence.h2.repository.PriceRepository;
import com.inditex.zara.exception.PriceNotFoundException;
import com.inditex.zara.query.FindPricesQuery;
import jakarta.persistence.NoResultException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles({"test"})
@TestPropertySource(
        properties = {"spring.config.location=classpath:application-test.yml"}
)
public class PriceRepositoryAdapterTest {

    @InjectMocks
    private H2QueryMapper mapper;

    @Mock
    private PriceRepository repository;

    private FindPricesQuery findPricesQuery;

    @BeforeEach
    public void setUp() {
        this.repository = Mockito.mock(PriceRepository.class);
        this.mapper = new H2QueryMapperImpl();
        String date = "2020-06-14 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        this.findPricesQuery = FindPricesQuery.builder()
                .priceDate(dateTime)
                .brandId(1L)
                .productId(35455L)
                .build();
    }

    @Test
    void findPriceByParametersReturn200(){
        String date = "2020-06-14 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        when(repository.findPrice(any(),any(),any()))
                .thenReturn(Optional.of(PriceEntity
                        .builder()
                                .id(UUID.randomUUID())
                                .price(35.50)
                                .brand(BrandEntity.builder()
                                        .id(1L)
                                        .description("ZARA")
                                        .build())
                                .currency("EUR")
                                .priceList(1L)
                                .startDate(dateTime)
                                .endDate(dateTime)
                                .priority(0L)
                                .productId(35455L)
                        .build()));
        var result = mapper.toPriceView(repository.findPrice(
                findPricesQuery.getProductId(), findPricesQuery.getBrandId(), findPricesQuery.getPriceDate()).get());
        assertEquals(result.getProductId(), result.getProductId());
        assertEquals(result.getPriceList(), result.getPriceList());
        assertEquals(result.getPrice(), result.getPrice());

    }

    @Test
    void findPriceByParametersReturn404(){

        when(repository.findPrice(any(),any(),any())).thenThrow(new NoResultException());

        var exception =
                assertThrows(
                        NoResultException.class,
                        () -> {
                            repository.findPrice(
                                    findPricesQuery.getProductId(),
                                    findPricesQuery.getBrandId(),
                                    findPricesQuery.getPriceDate());
                        },
                        "Price not found for this parameters");

        assertNotNull(exception);

    }


}
