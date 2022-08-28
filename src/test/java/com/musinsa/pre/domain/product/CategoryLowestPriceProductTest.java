package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CategoryLowestPriceProductTest {
    
    @DisplayName("카테고리 별로 최저가를 계산해서 반환한다.")
    @Test
    void filterDuplicatedCategory() {
        //given
        List<CategoryLowestPriceProductDto> categoryLowestPriceProductDtos = List.of(
                new CategoryLowestPriceProductDto("스니커즈", "A", new BigDecimal(1000)),
                new CategoryLowestPriceProductDto("스니커즈", "B", new BigDecimal(1000)),
                new CategoryLowestPriceProductDto("상의", "B", new BigDecimal(1500)),
                new CategoryLowestPriceProductDto("상의", "C", new BigDecimal(1500)),
                new CategoryLowestPriceProductDto("하의", "B", new BigDecimal(6500)),
                new CategoryLowestPriceProductDto("하의", "C", new BigDecimal(6500))
                );

        List<CategoryLowestPriceProductDto> expectedCategoryLowestPriceProductDtos = List.of(
                new CategoryLowestPriceProductDto("스니커즈", "A", new BigDecimal(1000)),
                new CategoryLowestPriceProductDto("상의", "B", new BigDecimal(1500)),
                new CategoryLowestPriceProductDto("하의", "B", new BigDecimal(6500))
        );
        

        //when
        CategoryLowestPriceProduct categoryLowestPriceProduct = 
                CategoryLowestPriceProduct.of(categoryLowestPriceProductDtos)
                        .filterDuplicatedCategory();
        
        //then
        assertEquals(expectedCategoryLowestPriceProductDtos, categoryLowestPriceProduct.toList());
    }
    
    
    @DisplayName("제품의 총 금액을 반환한다.")
    @Test
    void getTotalPrice() {
        //given 
        List<CategoryLowestPriceProductDto> categoryLowestPriceProductDtos = List.of(
                new CategoryLowestPriceProductDto("스니커즈", "A", new BigDecimal(1000)),
                new CategoryLowestPriceProductDto("상의", "B", new BigDecimal(1500)),
                new CategoryLowestPriceProductDto("하의", "B", new BigDecimal(6500))
        );

        CategoryLowestPriceProduct categoryLowestPriceProduct = CategoryLowestPriceProduct.of(categoryLowestPriceProductDtos);
        
        //when
        BigDecimal totalPrice = categoryLowestPriceProduct.getTotalPrice();

        //then
        assertEquals(new BigDecimal(9000), totalPrice);
    }
    

}
