package com.musinsa.pre.adapter.infra.jpa;

import com.musinsa.pre.domain.product.AllProductLowestPriceCategoryRepository;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import com.musinsa.pre.domain.product.dto.CategoryLowestBrandPrice;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.musinsa.pre.domain.brand.QBrand.brand;
import static com.musinsa.pre.domain.category.QCategory.category;
import static com.musinsa.pre.domain.product.QProduct.product;

@Repository
@RequiredArgsConstructor
public class AllProductLowestPriceCategoryRepositoryImpl implements AllProductLowestPriceCategoryRepository {

    private final JPAQueryFactory queryFactory;
    @Override
    public List<CategoryLowestBrandPrice> getAllProductLowestPrice() {
        return queryFactory.select(Projections.constructor(CategoryLowestBrandPrice.class,
                        category.id,brand.id,brand.name, product.price.min()))
                .from(product)
                .innerJoin(product.brand, brand)
                .innerJoin(product.category, category)
                .groupBy(product.brand.id,product.category.id)
                .fetch();
    }
    
}
