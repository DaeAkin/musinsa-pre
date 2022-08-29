package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.CategoryLowestBrandPrice;

import java.util.List;

public interface AllProductLowestPriceCategoryRepository {
    
    List<CategoryLowestBrandPrice> getAllProductLowestPrice();
}
