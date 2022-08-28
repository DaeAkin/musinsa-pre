package com.musinsa.pre.domain.product;

import com.musinsa.pre.adapter.config.QuerydslConfig;
import com.musinsa.pre.adapter.infra.jpa.CategoryLowestAndHighestPriceRepositoryImpl;
import com.musinsa.pre.adapter.infra.jpa.CategoryLowestPriceProductRepositoryImpl;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Import({QuerydslConfig.class, CategoryLowestAndHighestPriceRepositoryImpl.class})
@ActiveProfiles("test")
@DataJpaTest
@Sql("classpath:sample-data.sql")
class CategoryLowestAndHighestPriceRepositoryTest {
    
    @Autowired
    CategoryLowestAndHighestPriceRepository categoryLowestAndHighestPriceRepository;

    @DisplayName("해당 카테고리에 최고가 제품을 가져온다.")
    @Test
    void getHighestBrand() {
        //given
        
        //when
        BrandPrice highestBrand = categoryLowestAndHighestPriceRepository.getHighestBrand(1L);
        
        //then
        assertEquals(new BrandPrice("A",new BigDecimal("11200.00")), highestBrand);
    }

    @DisplayName("해당 카테고리에 최저가 제품을 가져온다.")
    @Test
    void getLowestBrand() {
        //given

        //when
        BrandPrice lowestBrand = categoryLowestAndHighestPriceRepository.getLowestBrand(1L);

        //then
        assertEquals(new BrandPrice("C",new BigDecimal("10000.00")), lowestBrand);
    }
}
