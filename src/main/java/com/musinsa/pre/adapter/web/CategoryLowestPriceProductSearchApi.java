package com.musinsa.pre.adapter.web;

import com.musinsa.pre.adapter.common.api.ApiResult;
import com.musinsa.pre.adapter.common.api.ContentWrapper;
import com.musinsa.pre.application.product.CategoryLowestPriceProductsFinder;
import com.musinsa.pre.application.product.dto.CategoryLowestPriceProductsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class CategoryLowestPriceProductSearchApi {
    
    private final CategoryLowestPriceProductsFinder categoryLowestPriceProductsFinder;
    
    @GetMapping("/search/categories/lowest-price")
    public ResponseEntity<ApiResult<ContentWrapper<CategoryLowestPriceProductsResponse>>> getLowestPrice() {
        CategoryLowestPriceProductsResponse lowestPriceProducts = categoryLowestPriceProductsFinder.findLowestPriceProductByCategories();
        return ResponseEntity.ok(ApiResult.content(lowestPriceProducts));
    }
}
