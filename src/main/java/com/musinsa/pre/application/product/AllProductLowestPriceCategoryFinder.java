package com.musinsa.pre.application.product;

import com.musinsa.pre.domain.product.AllProductLowestPriceCategoryRepository;
import com.musinsa.pre.domain.product.CategoryLowestBrandPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import com.musinsa.pre.domain.product.dto.CategoryLowestBrandPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AllProductLowestPriceCategoryFinder {
    
    private final AllProductLowestPriceCategoryRepository allProductLowestPriceCategoryRepository;
    
    @Transactional(readOnly = true)
    public BrandPrice getAllProductLowestPrice() {
        List<CategoryLowestBrandPrice> allProductLowestPrice = allProductLowestPriceCategoryRepository.getAllProductLowestPrice();
        return CategoryLowestBrandPrices.of(allProductLowestPrice).getLowestBrand();
    }
    
}
