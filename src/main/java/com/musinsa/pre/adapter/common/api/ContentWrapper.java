package com.musinsa.pre.adapter.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ContentWrapper<T> {
    private T content;
}
