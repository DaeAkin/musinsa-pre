package com.musinsa.pre.adapter.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class ContentsWrapper<T> {
    private static final ContentsWrapper EMPTY = new ContentsWrapper<>(Collections.emptyList());
    
    private long totalCount;

    
    private List<T> contents;

    public ContentsWrapper(List<T> contents) {
        if (CollectionUtils.isEmpty(contents)) {
            this.contents = Collections.emptyList();
        } else {
            this.totalCount = contents.size();
            this.contents = contents;
        }
    }
    
    public static <T> ContentsWrapper<T> empty() {
        return EMPTY;
    }
}
