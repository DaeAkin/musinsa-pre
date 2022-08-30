package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.CategoryLowestBrandPrice;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface AllProductLowestPriceCategoryRepository {

    @Cacheable(cacheNames = "getAllProductLowestPrice")
    List<CategoryLowestBrandPrice> getAllProductLowestPrice();
}
