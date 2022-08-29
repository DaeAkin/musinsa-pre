package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import com.musinsa.pre.domain.product.dto.CategoryLowestBrandPrice;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoryLowestBrandPrices {

    private final List<CategoryLowestBrandPrice> list;

    private CategoryLowestBrandPrices(List<CategoryLowestBrandPrice> list) {
        this.list = list;
    }

    public static CategoryLowestBrandPrices of(List<CategoryLowestBrandPrice> list) {
        return new CategoryLowestBrandPrices(list);
    }

    public BrandPrice getLowestBrand() {
        Map<String, BigDecimal> lowestProductBrands =
                list.stream()
                        .collect(Collectors.toMap(
                                CategoryLowestBrandPrice::getBrandName,
                                CategoryLowestBrandPrice::getPrice,
                                BigDecimal::add));
        Map.Entry<String, BigDecimal> lowestBrand = Collections.min(lowestProductBrands.entrySet(), (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        return new BrandPrice(lowestBrand.getKey(), lowestBrand.getValue());
    }
}
