package com.musinsa.pre.adapter.web;

import com.musinsa.pre.adapter.common.api.ApiResult;
import com.musinsa.pre.adapter.common.api.ContentWrapper;
import com.musinsa.pre.application.product.CategoryLowestAndHighestPriceFinder;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class CategoryLowestAndHighestPriceSearchApi {
    
    private final CategoryLowestAndHighestPriceFinder categoryLowestAndHighestPriceFinder;
    
    @GetMapping("/categories/{categoryName}/brands/lowest-highest-price")
    public ResponseEntity<ApiResult<ContentWrapper<BrandsLowestAndHighestPrices>>> getMinAndMaxPrice(@PathVariable String categoryName) {
        BrandsLowestAndHighestPrices brandsLowestAndHighestPrices = categoryLowestAndHighestPriceFinder.getMinAndMaxPrice(categoryName);
        
        return ResponseEntity.ok(ApiResult.content(brandsLowestAndHighestPrices)); 
    }
}
