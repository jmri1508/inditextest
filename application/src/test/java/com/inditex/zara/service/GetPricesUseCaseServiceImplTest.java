package com.inditex.zara.service;

import com.inditex.zara.entity.PriceView;
import com.inditex.zara.exception.PriceNotFoundException;
import com.inditex.zara.ports.PriceRepositoryPort;
import com.inditex.zara.query.FindPricesQuery;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ActiveProfiles({"test"})
@TestPropertySource(
        properties = {"spring.config.location=classpath:application-test.yml"}
)
public class GetPricesUseCaseServiceImplTest {

    @Mock
    private PriceRepositoryPort priceRepository;

    @InjectMocks
    private GetPricesUseCaseServiceImpl getPricesUseCaseService;

    @BeforeEach
    public void setUp() {
        priceRepository = Mockito.mock(PriceRepositoryPort.class);
        this.getPricesUseCaseService = new GetPricesUseCaseServiceImpl(priceRepository);
    }

    private PriceView getPriceView(Long priceList,
                                   LocalDateTime startDate,
                                   LocalDateTime endDate,
                                   Double price){
        return PriceView.builder()
                .id(UUID.fromString("c118e472-e3e3-40f8-8534-dec571e443a9"))
                .productId(35455L)
                .brandId(1L)
                .priceList(priceList)
                .price(price)
                .startDate(startDate)
                .endDate(endDate)
                .price(price)
                .priority(1L)
                .currency("EUR")
                .build();
    }

    @Test
    void executeWithPriceDateCase1() throws PriceNotFoundException {

        String date = "2020-06-14 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        date = "2020-06-14 00:00:00";
        LocalDateTime dateTimeStart = LocalDateTime.parse(date, formatter);
        date = "2020-12-31 23:59:59";
        LocalDateTime dateTimeEnd = LocalDateTime.parse(date, formatter);

        PriceView priceView = getPriceView(1L,dateTimeStart, dateTimeEnd,35.50);


        when(priceRepository.findPriceByParameters(any(FindPricesQuery.class)))
                .thenReturn(Optional.of(priceView));

        PriceView response = getPricesUseCaseService.execute(
                FindPricesQuery.builder().brandId(1L).productId(35455L).priceDate(dateTime).build()
        );

        PriceView result = getPriceView(1L,dateTimeStart, dateTimeEnd,35.50);
        assertEquals(result,response);
    }

    @Test
    void executeWithPriceDateCase2() throws PriceNotFoundException {

        String date = "2020-06-14 16:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        date = "2020-06-14 15:00:00";
        LocalDateTime dateTimeStart = LocalDateTime.parse(date, formatter);
        date = "2020-06-14 18:30:00";
        LocalDateTime dateTimeEnd = LocalDateTime.parse(date, formatter);

        PriceView priceView = getPriceView(2L,dateTimeStart, dateTimeEnd,25.45);


        when(priceRepository.findPriceByParameters(any(FindPricesQuery.class)))
                .thenReturn(Optional.of(priceView));

        PriceView response = getPricesUseCaseService.execute(
                FindPricesQuery.builder().brandId(1L).productId(35455L).priceDate(dateTime).build()
        );

        PriceView result = getPriceView(2L,dateTimeStart, dateTimeEnd,25.45);
        assertEquals(result,response);
    }

    @Test
    void executeWithPriceDateCase3() throws PriceNotFoundException {

        String date = "2020-06-14 21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        date = "2020-06-14 00:00:00";
        LocalDateTime dateTimeStart = LocalDateTime.parse(date, formatter);
        date = "2020-12-31 23:59:59";
        LocalDateTime dateTimeEnd = LocalDateTime.parse(date, formatter);

        PriceView priceView = getPriceView(1L,dateTimeStart, dateTimeEnd,35.50);


        when(priceRepository.findPriceByParameters(any(FindPricesQuery.class)))
                .thenReturn(Optional.of(priceView));

        PriceView response = getPricesUseCaseService.execute(
                FindPricesQuery.builder().brandId(1L).productId(35455L).priceDate(dateTime).build()
        );

        PriceView result = getPriceView(1L,dateTimeStart, dateTimeEnd,35.50);
        assertEquals(result,response);
    }

    @Test
    void executeWithPriceDateCase4() throws PriceNotFoundException {

        String date = "2020-06-15 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        date = "2020-06-15 00:00:00";
        LocalDateTime dateTimeStart = LocalDateTime.parse(date, formatter);
        date = "2020-06-15 11:00:00";
        LocalDateTime dateTimeEnd = LocalDateTime.parse(date, formatter);

        PriceView priceView = getPriceView(3L,dateTimeStart, dateTimeEnd,30.5);


        when(priceRepository.findPriceByParameters(any(FindPricesQuery.class)))
                .thenReturn(Optional.of(priceView));

        PriceView response = getPricesUseCaseService.execute(
                FindPricesQuery.builder().brandId(1L).productId(35455L).priceDate(dateTime).build()
        );

        PriceView result = getPriceView(3L,dateTimeStart, dateTimeEnd,30.5);
        assertEquals(result,response);
    }

    @Test
    void executeWithPriceDateCase5() throws PriceNotFoundException {

        String date = "2020-06-16 21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        date = "2020-06-15 16:00:00";
        LocalDateTime dateTimeStart = LocalDateTime.parse(date, formatter);
        date = "2020-12-31 23:59:59";
        LocalDateTime dateTimeEnd = LocalDateTime.parse(date, formatter);

        PriceView priceView = getPriceView(4L,dateTimeStart, dateTimeEnd,38.95);


        when(priceRepository.findPriceByParameters(any(FindPricesQuery.class)))
                .thenReturn(Optional.of(priceView));

        PriceView response = getPricesUseCaseService.execute(
                FindPricesQuery.builder().brandId(1L).productId(35455L).priceDate(dateTime).build()
        );

        PriceView result = getPriceView(4L,dateTimeStart, dateTimeEnd,38.95);
        assertEquals(result,response);
    }

    @Test
    void executeNotFoundException() throws PriceNotFoundException {

        String date = "2020-06-16 21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        when(priceRepository.findPriceByParameters(any(FindPricesQuery.class)))
                .thenReturn(Optional.empty());

        PriceNotFoundException exception =
                assertThrows(
                        PriceNotFoundException.class,
                        () -> {
                            getPricesUseCaseService.execute(FindPricesQuery.builder()
                                    .brandId(1L)
                                    .productId(35455L)
                                    .priceDate(dateTime)
                                    .build());
                        },
                        "Price not found for this parameters");

                assertEquals("Price not found for this parameters.", exception.getDescription());
    }


}
