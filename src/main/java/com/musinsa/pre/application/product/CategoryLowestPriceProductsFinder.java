package com.musinsa.pre.application.product;

import com.musinsa.pre.application.product.dto.CategoryLowestPriceProductsResponse;
import com.musinsa.pre.domain.product.CategoryLowestPriceProduct;
import com.musinsa.pre.domain.product.CategoryLowestPriceProductsRepository;
import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryLowestPriceProductsFinder {
    
    private final CategoryLowestPriceProductsRepository categoryLowestPriceProductsRepository;
    
    @Transactional(readOnly = true)
    public CategoryLowestPriceProductsResponse findLowestPriceProductByCategories() {
        List<CategoryLowestPriceProductDto> categoryLowestPriceProductDtos = categoryLowestPriceProductsRepository.searchAllCategoriesLowestPriceProduct();
        
        CategoryLowestPriceProduct categoryLowestPriceProduct = 
                CategoryLowestPriceProduct.of(categoryLowestPriceProductDtos)
                        .filterDuplicatedCategory();
        
        return new CategoryLowestPriceProductsResponse(categoryLowestPriceProduct.toList(),
                categoryLowestPriceProduct.getTotalPrice());
    }
}
