package com.musinsa.pre.adapter.web;

import com.musinsa.pre.application.product.AllProductLowestPriceCategoryFinder;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
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

@WebMvcTest(AllProductLowestPriceCategoryApi.class)
class AllProductLowestPriceCategoryApiTest extends WebMvcTestSupport {

    @Autowired
    AllProductLowestPriceCategoryApi allProductLowestPriceCategoryApi;
    
    @MockBean
    AllProductLowestPriceCategoryFinder allProductLowestPriceCategoryFinder;
    
    @DisplayName("한 브랜드에서 모든 카테고리의 상품을 한꺼번에 구매할 경우 최저가 및 브랜드를 조회한다.")
    @Test
    void getAllProductLowestPrice() throws Exception {
        //given
        BrandPrice brandPrice = EnhancedRandom.random(BrandPrice.class);
        given(allProductLowestPriceCategoryFinder.getAllProductLowestPrice()).willReturn(brandPrice);

        //when && then
        ResultActions result = mvc.perform(get("/v1/products/all/categories/brands/lowest-price")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8"))
                .andDo(print());

        result.andExpect(status().isOk())
                .andExpect(jsonPath("result.content.brandName").value(brandPrice.getBrandName()))
                .andExpect(jsonPath("result.content.price").value(brandPrice.getPrice()));
    }
}
