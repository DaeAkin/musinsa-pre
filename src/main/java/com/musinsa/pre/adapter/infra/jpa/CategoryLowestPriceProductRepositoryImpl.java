package com.musinsa.pre.adapter.infra.jpa;

import com.musinsa.pre.domain.product.CategoryLowestPriceProductsRepository;
import com.musinsa.pre.domain.product.dto.CategoryLowestPriceProductDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.musinsa.pre.domain.brand.QBrand.brand;
import static com.musinsa.pre.domain.category.QCategory.category;
import static com.musinsa.pre.domain.product.QProduct.product;

@Repository
@RequiredArgsConstructor
public class CategoryLowestPriceProductRepositoryImpl implements CategoryLowestPriceProductsRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<CategoryLowestPriceProductDto> searchAllCategoriesLowestPriceProduct() {
        List<Tuple> categoryLowestPrices = getLowestPriceInCategory();
        return queryFactory.select(Projections.constructor(CategoryLowestPriceProductDto.class,
                        category.name, product.brand.name, product.price))
                .from(product)
                .where(Expressions.list(product.category.id, product.price).in(categoryPriceIn(categoryLowestPrices)))
                .innerJoin(product.category, category)
                .innerJoin(product.brand, brand)
                .fetch();
    }

    private Expression[] categoryPriceIn(List<Tuple> categoryLowestPrices) {
        List<Expression> tuples = new ArrayList<>();

        for (Tuple categoryLowestPrice : categoryLowestPrices) {
            tuples.add(Expressions.template(Object.class, "({0}, {1})",
                    categoryLowestPrice.get(0, Long.class),
                    categoryLowestPrice.get(1, BigDecimal.class)));
        }

        return tuples.toArray(new Expression[0]);
    }
    
    private List<Tuple> getLowestPriceInCategory() {
        return queryFactory.select(category.id, product.price.min())
                .from(product)
                .groupBy(category.id)
                .fetch();
    }
}
