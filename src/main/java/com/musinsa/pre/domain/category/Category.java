package com.musinsa.pre.domain.category;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Category {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
