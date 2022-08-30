package com.musinsa.pre.application.product;

import com.musinsa.pre.application.product.dto.CategoryLowestPriceProductsResponse;
import com.musinsa.pre.domain.product.CategoryLowestPriceProductsRepository;
import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CategoryLowestPriceProductsFinderTest {

    @InjectMocks
    CategoryLowestPriceProductsFinder categoryLowestPriceProductsFinder;
    
    @Mock
    CategoryLowestPriceProductsRepository categoryLowestPriceProductsRepository;
    
    @DisplayName("카테고리에서 최저가 제품을 가져온다.")
    @Test
    void findLowestPriceProductByCategories() {
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
        given(categoryLowestPriceProductsRepository.searchAllCategoriesLowestPriceProduct())
                .willReturn(categoryLowestPriceProductDtos);
        
        //when
        CategoryLowestPriceProductsResponse lowestPriceProductByCategories = categoryLowestPriceProductsFinder.findLowestPriceProductByCategories();

        //then
        assertEquals(expectedCategoryLowestPriceProductDtos, lowestPriceProductByCategories.getProducts());
        assertEquals(new BigDecimal(9000), lowestPriceProductByCategories.getPrice());
    }
}
