package com.musinsa.pre.application.product;

import com.musinsa.pre.domain.category.Category;
import com.musinsa.pre.domain.category.CategoryRepository;
import com.musinsa.pre.domain.category.exception.CategoryNotFoundException;
import com.musinsa.pre.domain.product.CategoryLowestAndHighestPriceRepository;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryLowestAndHighestPriceFinder {
    
    private final CategoryRepository categoryRepository;
    private final CategoryLowestAndHighestPriceRepository categoryLowestAndHighestPriceRepository;
    
    @Transactional(readOnly = true)
    public BrandsLowestAndHighestPrices getMinAndMaxPrice(String categoryName) {
        Category category = categoryRepository.findByName(categoryName).orElseThrow(() -> new CategoryNotFoundException(categoryName));

        return new BrandsLowestAndHighestPrices(
                categoryLowestAndHighestPriceRepository.getHighestBrand(category.getId()),
                categoryLowestAndHighestPriceRepository.getLowestBrand(category.getId()));
    }
}
