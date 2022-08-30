package com.musinsa.pre.domain.product.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CategoryLowestBrandPrice {
    
    private final Long categoryId;
    private final Long brandId;
    private final String brandName;
    private final BigDecimal price;

    @QueryProjection
    public CategoryLowestBrandPrice(Long categoryId, Long brandId, String brandName, BigDecimal price) {
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.brandName = brandName;
        this.price = price;
    }
}
