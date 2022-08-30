package com.musinsa.pre.adapter.infra.jpa;

import com.musinsa.pre.domain.product.CategoryLowestAndHighestPriceRepository;
import com.musinsa.pre.domain.product.dto.BrandsLowestAndHighestPrices.BrandPrice;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import static com.musinsa.pre.domain.brand.QBrand.brand;
import static com.musinsa.pre.domain.category.QCategory.category;
import static com.musinsa.pre.domain.product.QProduct.product;

@Repository
@RequiredArgsConstructor
public class CategoryLowestAndHighestPriceRepositoryImpl implements CategoryLowestAndHighestPriceRepository {

    private final JPAQueryFactory queryFactory;
    @Cacheable(cacheNames = "getHighestBrand")
    @Override
    public BrandPrice getHighestBrand(Long categoryId) {
        return queryFactory.select(Projections.constructor(BrandPrice.class,
                product.brand.name, product.price))
                .from(product)
                .where(product.category.id.eq(categoryId))
                .innerJoin(product.brand, brand)
                .innerJoin(product.category, category)
                .groupBy(category, brand)
                .orderBy(product.price.desc())
                .fetchFirst();
    }


    @Cacheable(cacheNames = "getLowestBrand")
    @Override
    public BrandPrice getLowestBrand(Long categoryId) {
        return queryFactory.select(Projections.constructor(BrandPrice.class,
                        product.brand.name, product.price))
                .from(product)
                .where(product.category.id.eq(categoryId))
                .innerJoin(product.brand, brand)
                .innerJoin(product.category, category)
                .groupBy(category, brand)
                .orderBy(product.price.asc())
                .fetchFirst();
    }
}
