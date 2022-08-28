package com.musinsa.pre.application.product;

import com.musinsa.pre.domain.category.Category;
import com.musinsa.pre.domain.category.CategoryRepository;
import com.musinsa.pre.domain.category.exception.CategoryNotFoundException;
import com.musinsa.pre.domain.product.CategoryLowestAndHighestPriceRepository;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CategoryLowestAndHighestPriceFinderTest {

    @InjectMocks
    CategoryLowestAndHighestPriceFinder categoryLowestAndHighestPriceFinder;
    
    @Mock
    CategoryRepository categoryRepository;
    
    @Mock
    CategoryLowestAndHighestPriceRepository categoryLowestAndHighestPriceRepository;
    
    
    @Nested
    @DisplayName("카테고리 이름으로 최소, 최대 가격 조회를 한다.")
    class getMinAndMaxPrice {
        
        @Test
        @DisplayName("카테고리가 존재하지 않을 경우 CategoryNotFoundException이 발생한다.")
        void getMinAndMaxPrice_1() {
            //given
            String randomCategory = random(String.class);
            given(categoryRepository.findByName(any())).willReturn(Optional.empty());
            
            //when && then
            assertThrows(CategoryNotFoundException.class,() -> categoryLowestAndHighestPriceFinder.getMinAndMaxPrice(randomCategory));
        }

        @Test
        @DisplayName("브랜드의 최소, 최대 가격을 반환한다.")
        void getMinAndMaxPrice_2() {
            //given
            Category randomCategory = random(Category.class);
            BrandPrice highBrandPrice = random(BrandPrice.class);
            BrandPrice lowBrandPrice = random(BrandPrice.class);
            
            given(categoryRepository.findByName(randomCategory.getName())).willReturn(Optional.of(randomCategory));
            given(categoryLowestAndHighestPriceRepository.getHighestBrand(randomCategory.getId())).willReturn(highBrandPrice);
            given(categoryLowestAndHighestPriceRepository.getLowestBrand(randomCategory.getId())).willReturn(lowBrandPrice);

            //when
            BrandsLowestAndHighestPrices minAndMaxPrice = categoryLowestAndHighestPriceFinder.getMinAndMaxPrice(randomCategory.getName());
            
            //then
            assertEquals(highBrandPrice , minAndMaxPrice.getHighestPriceBrand());
            assertEquals(lowBrandPrice , minAndMaxPrice.getLowestPriceBrand());
        }
    }
}
