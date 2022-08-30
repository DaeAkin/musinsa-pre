package com.musinsa.pre.application.product.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.musinsa.pre.adapter.config.MoneySerializer;
import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryLowestPriceProductsResponse {
    
    private List<CategoryLowestPriceProductDto> products;
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal price;
}

