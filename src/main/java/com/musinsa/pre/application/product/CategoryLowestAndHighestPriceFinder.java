package com.musinsa.pre.application.product;

import com.musinsa.pre.domain.category.Category;
import com.musinsa.pre.domain.category.CategoryRepository;
import com.musinsa.pre.domain.category.exception.CategoryNotFoundException;
import com.musinsa.pre.domain.product.CategoryLowestAndHighestPriceRepository;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryLowestAndHighestPriceFinder {
    
    private final CategoryRepository categoryRepository;
    private final CategoryLowestAndHighestPriceRepository categoryLowestAndHighestPriceRepository;
    
    public BrandsLowestAndHighestPrices getMinAndMaxPrice(String categoryName) {
        Category category = categoryRepository.findByName(categoryName).orElseThrow(() -> new CategoryNotFoundException(categoryName));

        return new BrandsLowestAndHighestPrices(
                categoryLowestAndHighestPriceRepository.getHighestBrand(category.getId()),
                categoryLowestAndHighestPriceRepository.getLowestBrand(category.getId()));
    }
}
