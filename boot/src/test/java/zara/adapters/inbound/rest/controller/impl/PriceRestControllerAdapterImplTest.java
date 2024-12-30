package zara.adapters.inbound.rest.controller.impl;

import com.inditex.zara.ZaraApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import zara.utils.PriceUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {ZaraApplication.class})
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
@TestPropertySource(
        properties = {"spring.config.location=classpath:application-test.yml"}
)
public class PriceRestControllerAdapterImplTest {

    @Value("${api.endpoints.price.mapping}")
    private String baseUrl;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void given_resource_when_case1_then_shouldReturnTheResource_AndStatus200() throws Exception {

        String productId = "35455";
        String brandId = "1";
        String date = "2020-06-14 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .param("priceDate", String.valueOf(dateTime)))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        assertEquals(PriceUtils.returnCase1And3Result(),mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void given_resource_when_case2_then_shouldReturnTheResource_AndStatus200() throws Exception {

        String productId = "35455";
        String brandId = "1";
        String date = "2020-06-14 16:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .param("priceDate", String.valueOf(dateTime)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(PriceUtils.returnCase2Result(),mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void given_resource_when_case3_then_shouldReturnTheResource_AndStatus200() throws Exception {

        String productId = "35455";
        String brandId = "1";
        String date = "2020-06-14 21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .param("priceDate", String.valueOf(dateTime)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(PriceUtils.returnCase1And3Result(),mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void given_resource_when_case4_then_shouldReturnTheResource_AndStatus200() throws Exception {

        String productId = "35455";
        String brandId = "1";
        String date = "2020-06-15 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .param("priceDate", String.valueOf(dateTime)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(PriceUtils.returnCase4Result(),mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void given_resource_when_case5_then_shouldReturnTheResource_AndStatus200() throws Exception {

        String productId = "35455";
        String brandId = "1";
        String date = "2020-06-16 21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(baseUrl)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .param("priceDate", String.valueOf(dateTime)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(PriceUtils.returnCase5Result(),mvcResult.getResponse().getContentAsString());
    }

}
