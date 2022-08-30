package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;

import java.util.List;
public interface CategoryLowestPriceProductsRepository {
    
    List<CategoryLowestPriceProductDto> searchAllCategoriesLowestPriceProduct();
    
}
