package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;

public interface CategoryLowestAndHighestPriceRepository {
    
    BrandPrice getHighestBrand(Long categoryId);
    
    BrandPrice getLowestBrand(Long categoryId);
}
