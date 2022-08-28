package com.musinsa.pre.application.product.dto;

import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryLowestPriceProductsResponse {
    
    private List<CategoryLowestPriceProductDto> products;  
    private BigDecimal price;
}

