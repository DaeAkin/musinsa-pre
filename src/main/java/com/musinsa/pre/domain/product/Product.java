package com.musinsa.pre.domain.product;

import com.musinsa.pre.domain.brand.Brand;
import com.musinsa.pre.domain.category.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
