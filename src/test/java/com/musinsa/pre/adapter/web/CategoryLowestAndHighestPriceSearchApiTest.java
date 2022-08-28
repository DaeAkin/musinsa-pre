package com.musinsa.pre.adapter.web;

import com.musinsa.pre.application.product.CategoryLowestAndHighestPriceFinder;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.test.WebMvcTestSupport;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryLowestAndHighestPriceSearchApi.class)
class CategoryLowestAndHighestPriceSearchApiTest extends WebMvcTestSupport {
    
    @Autowired
    CategoryLowestAndHighestPriceSearchApi categoryLowestAndHighestPriceSearchApi;
    
    @MockBean
    CategoryLowestAndHighestPriceFinder categoryLowestAndHighestPriceFinder;

    @DisplayName("카테고리 이름으로 최소, 최대 가격 조회를 한다.")
    @Test
    void getMinAndMaxPrice() throws Exception {
        //given
        BrandsLowestAndHighestPrices brandsLowestAndHighestPrices = EnhancedRandom.random(BrandsLowestAndHighestPrices.class);
        given(categoryLowestAndHighestPriceFinder.getMinAndMaxPrice(any())).willReturn(brandsLowestAndHighestPrices);

        //when && then
        ResultActions result = mvc.perform(get("/v1/products/categories/카테고리/brands/lowest-highest-price")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andDo(print());

        result.andExpect(status().isOk())
                .andExpect(jsonPath("result.content.highestPriceBrand.brandName").value(brandsLowestAndHighestPrices.getHighestPriceBrand().getBrandName()))
                .andExpect(jsonPath("result.content.highestPriceBrand.price").value(brandsLowestAndHighestPrices.getHighestPriceBrand().getPrice()))
                .andExpect(jsonPath("result.content.lowestPriceBrand.brandName").value(brandsLowestAndHighestPrices.getLowestPriceBrand().getBrandName()))
                .andExpect(jsonPath("result.content.lowestPriceBrand.price").value(brandsLowestAndHighestPrices.getLowestPriceBrand().getPrice()));
                
    }
}
