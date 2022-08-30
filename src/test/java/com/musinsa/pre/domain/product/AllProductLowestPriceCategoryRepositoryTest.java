package com.musinsa.pre.domain.product;

import com.musinsa.pre.adapter.config.QuerydslConfig;
import com.musinsa.pre.adapter.infra.jpa.AllProductLowestPriceCategoryRepositoryImpl;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.CategoryLowestBrandPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Import({QuerydslConfig.class, AllProductLowestPriceCategoryRepositoryImpl.class})
@ActiveProfiles("test")
@DataJpaTest
@Sql("classpath:sample-data.sql")
class AllProductLowestPriceCategoryRepositoryTest {

    @Autowired
    AllProductLowestPriceCategoryRepository allProductLowestPriceCategoryRepository;

    @DisplayName("해당 카테고리의 해당 브랜드의 가장 최저가들의 리스트들을 가져온다.")
    @Test
    void getAllProductLowestPrice() {
        //given

        //when
        List<CategoryLowestBrandPrice> allProductLowestPrice = allProductLowestPriceCategoryRepository.getAllProductLowestPrice();
        
        //then
        assertEquals(9, allProductLowestPrice.size());
    }
}
