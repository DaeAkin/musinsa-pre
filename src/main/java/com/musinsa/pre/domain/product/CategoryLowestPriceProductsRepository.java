package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;

import java.util.List;
import org.springframework.cache.annotation.Cacheable;
public interface CategoryLowestPriceProductsRepository {
    
    @Cacheable(cacheNames = "searchAllCategoriesLowestPriceProduct")
    List<CategoryLowestPriceProductDto> searchAllCategoriesLowestPriceProduct();
    
}
