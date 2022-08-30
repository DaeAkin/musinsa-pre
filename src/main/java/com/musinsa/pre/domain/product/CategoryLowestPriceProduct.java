package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;

import java.math.BigDecimal;
import java.util.*;

public class CategoryLowestPriceProduct {

    private final List<CategoryLowestPriceProductDto> list;

    private CategoryLowestPriceProduct(List<CategoryLowestPriceProductDto> list) {
        this.list = list;
    }

    public static CategoryLowestPriceProduct of(List<CategoryLowestPriceProductDto> list) {
        return new CategoryLowestPriceProduct(list);
    }

    public CategoryLowestPriceProduct filterDuplicatedCategory() {
        Set<String> categorySet = new HashSet<>();

        List<CategoryLowestPriceProductDto> result = new ArrayList<>();

        for (CategoryLowestPriceProductDto categoryLowestPriceProduct : list) {
            String categoryName = categoryLowestPriceProduct.getCategory();
            if (!categorySet.contains(categoryName)) {
                result.add(categoryLowestPriceProduct);
                categorySet.add(categoryName);
            }
        }
        
        return new CategoryLowestPriceProduct(result);
    }
    

    public BigDecimal getTotalPrice() {
        return list.stream()
                .map(CategoryLowestPriceProductDto::getPrice)
                .reduce(new BigDecimal(0), BigDecimal::add);
    }

    public List<CategoryLowestPriceProductDto> toList() {
        return Collections.unmodifiableList(list);
    }
}
