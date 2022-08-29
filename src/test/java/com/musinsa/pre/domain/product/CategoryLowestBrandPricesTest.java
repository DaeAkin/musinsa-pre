package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import com.musinsa.pre.domain.product.dto.CategoryLowestBrandPrice;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryLowestBrandPricesTest {

    @Test
    void getLowestBrand() {
        //given
        List<CategoryLowestBrandPrice> categoryLowestBrandPrices = List.of(
                new CategoryLowestBrandPrice(1L, 1L, "A", new BigDecimal(11200)),
                new CategoryLowestBrandPrice(2L, 1L, "A", new BigDecimal(3000)),
                new CategoryLowestBrandPrice(1L, 2L, "B", new BigDecimal(4000)),
                new CategoryLowestBrandPrice(2L, 2L, "B", new BigDecimal(5000))
        );
        CategoryLowestBrandPrices of = CategoryLowestBrandPrices.of(categoryLowestBrandPrices);
        
        //when
        BrandPrice lowestBrand = of.getLowestBrand();
        
        //then
        assertEquals(new BrandPrice("B",new BigDecimal(9000)), lowestBrand);
    }
}
