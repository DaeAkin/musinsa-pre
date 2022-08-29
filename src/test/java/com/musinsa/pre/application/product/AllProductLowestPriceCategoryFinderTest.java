package com.musinsa.pre.application.product;

import com.musinsa.pre.domain.product.AllProductLowestPriceCategoryRepository;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import com.musinsa.pre.domain.product.dto.CategoryLowestBrandPrice;
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
class AllProductLowestPriceCategoryFinderTest {
    
    @InjectMocks
    AllProductLowestPriceCategoryFinder allProductLowestPriceCategoryFinder;
    
    @Mock
    AllProductLowestPriceCategoryRepository allProductLowestPriceCategoryRepository;

    @DisplayName("한 브랜드에서 모든 카테고리의 상품을 한꺼번에 구매할 경우 최저가 및 브랜드 조회한다.")
    @Test
    void getAllProductLowestPrice() {
        //given
        List<CategoryLowestBrandPrice> categoryLowestBrandPrices = List.of(
                new CategoryLowestBrandPrice(1L, 1L, "A", new BigDecimal(11200)),
                new CategoryLowestBrandPrice(2L, 1L, "A", new BigDecimal(3000)),
                new CategoryLowestBrandPrice(1L, 2L, "B", new BigDecimal(4000)),
                new CategoryLowestBrandPrice(2L, 2L, "B", new BigDecimal(5000))
        );
        given(allProductLowestPriceCategoryRepository.getAllProductLowestPrice()).willReturn(categoryLowestBrandPrices);
        
        //when
        BrandPrice lowestBrand = allProductLowestPriceCategoryFinder.getAllProductLowestPrice();

        //then
        assertEquals(new BrandPrice("B",new BigDecimal(9000)), lowestBrand);
    }
}
