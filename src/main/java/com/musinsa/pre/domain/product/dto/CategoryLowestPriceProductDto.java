package com.musinsa.pre.domain.product.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@EqualsAndHashCode
public class CategoryLowestPriceProductDto {
    
    private String category;
    private String brand;
    private BigDecimal price;


    @QueryProjection
    public CategoryLowestPriceProductDto(String category, String brand, BigDecimal price) {
        this.category = category;
        this.brand = brand;
        this.price = price;
    }
}
