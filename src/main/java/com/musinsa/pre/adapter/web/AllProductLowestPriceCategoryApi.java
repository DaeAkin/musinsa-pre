package com.musinsa.pre.adapter.web;

import com.musinsa.pre.adapter.common.api.ApiResult;
import com.musinsa.pre.adapter.common.api.ContentWrapper;
import com.musinsa.pre.application.product.AllProductLowestPriceCategoryFinder;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class AllProductLowestPriceCategoryApi {
    
    private final AllProductLowestPriceCategoryFinder allProductLowestPriceCategoryFinder;
    
    @GetMapping("/all/categories/brands/lowest-price")
    public ResponseEntity<ApiResult<ContentWrapper<BrandPrice>>> getAllProductLowestPrice() {
        BrandPrice allProductLowestPrice = allProductLowestPriceCategoryFinder.getAllProductLowestPrice();
        
        return ResponseEntity.ok(ApiResult.content(allProductLowestPrice));
    }
}
