package com.musinsa.pre.domain.category.exception;

import com.musinsa.pre.domain.common.MusinsaCommonException;

public class CategoryNotFoundException extends MusinsaCommonException {
    private static final String MESSAGE = "해당 카테고리가 존재하지 않습니다. : %s"; 
    private final String categoryName;
    
    public CategoryNotFoundException(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE, categoryName);
    }
}
