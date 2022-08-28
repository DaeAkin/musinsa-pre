package com.musinsa.pre.domain.product;

import com.musinsa.pre.adapter.config.QuerydslConfig;
import com.musinsa.pre.adapter.infra.jpa.CategoryLowestPriceProductRepositoryImpl;
import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Import({QuerydslConfig.class, CategoryLowestPriceProductRepositoryImpl.class})
@ActiveProfiles("test")
@DataJpaTest
@Sql("classpath:sample-data.sql")
class CategoryLowestPriceProductsRepositoryTest {

    @Autowired
    CategoryLowestPriceProductsRepository categoryLowestPriceProductsRepository;


    @DisplayName("카테고리별 최저가 제품을 조회한다.")
    @Test
    void searchAllCategoriesLowestPriceProduct() {
        //given
        List<CategoryLowestPriceProductDto> expectedCategoryLowestPriceProductDtos = List.of(
                new CategoryLowestPriceProductDto("아우터", "A", new BigDecimal("5500.00")),
                new CategoryLowestPriceProductDto("상의", "C", new BigDecimal("10000.00")),
                new CategoryLowestPriceProductDto("바지", "C", new BigDecimal("3300.00"))
        );

        //when
        List<CategoryLowestPriceProductDto> categoryLowestPriceProductDtos =
                categoryLowestPriceProductsRepository.searchAllCategoriesLowestPriceProduct();

        //then
        assertEquals(expectedCategoryLowestPriceProductDtos, categoryLowestPriceProductDtos);
    }
}
