package com.musinsa.pre.adapter.web;

import com.musinsa.pre.application.product.CategoryLowestPriceProductsFinder;
import com.musinsa.pre.application.product.dto.CategoryLowestPriceProductsResponse;
import com.musinsa.pre.test.WebMvcTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryLowestPriceProductSearchApi.class)
class CategoryLowestPriceProductSearchApiTest extends WebMvcTestSupport {

    @Autowired
    CategoryLowestPriceProductSearchApi categoryLowestPriceProductSearchApi;
    
    @MockBean
    CategoryLowestPriceProductsFinder categoryLowestPriceProductsFinder;

    @DisplayName("한 브랜드에서 모든 카테고리의 상품을 한꺼번에 구매할 경우 최저가 및 브랜드 조회 API")
    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    class getLowestPrice {


        @DisplayName("카테고리 별 최저가를 조회한다.")
        @Test
        void getLowestPrice() throws Exception {
            //given
            CategoryLowestPriceProductsResponse randomResponse = random(CategoryLowestPriceProductsResponse.class);
            given(categoryLowestPriceProductsFinder.findLowestPriceProductByCategories()).willReturn(randomResponse);

            //when && then
            ResultActions result = mvc.perform(get("/v1/products/search/categories/lowest-price")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8"))
                    .andDo(print());

            result.andExpect(status().isOk())
                    .andExpect(jsonPath("result.content.price").value(randomResponse.getPrice()))
                    .andExpect(jsonPath("$.result.content.products").exists());
        }
    }
}
