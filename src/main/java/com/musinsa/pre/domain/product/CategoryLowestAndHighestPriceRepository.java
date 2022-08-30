package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import org.springframework.cache.annotation.Cacheable;

public interface CategoryLowestAndHighestPriceRepository {

    @Cacheable(cacheNames = "getHighestBrand")
    BrandPrice getHighestBrand(Long categoryId);
    @Cacheable(cacheNames = "getLowestBrand")
    BrandPrice getLowestBrand(Long categoryId);
}
