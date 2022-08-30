package com.musinsa.pre.domain.product.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.musinsa.pre.adapter.config.MoneySerializer;
import com.querydsl.core.annotations.QueryProjection;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
public class BrandsLowestAndHighestPrices {
    private BrandPrice highestPriceBrand;
    private BrandPrice lowestPriceBrand;

    public BrandsLowestAndHighestPrices(BrandPrice highestPriceBrand, BrandPrice lowestPriceBrand) {
        this.highestPriceBrand = highestPriceBrand;
        this.lowestPriceBrand = lowestPriceBrand;
    }

    @Getter
    @EqualsAndHashCode
    @ToString
    public static class BrandPrice {
        private String brandName;
        @JsonSerialize(using = MoneySerializer.class)
        private BigDecimal price;

        @QueryProjection
        public BrandPrice(String brandName, BigDecimal price) {
            this.brandName = brandName;
            this.price = price;
        }
    }
    
}


