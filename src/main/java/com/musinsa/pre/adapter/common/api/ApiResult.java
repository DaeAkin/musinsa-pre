package com.musinsa.pre.adapter.common.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * 기본 API 응답 모델
 */
@Value
public class ApiResult<T> {
    public static final ApiResult SUCCESS_RESPONSE = new ApiResult(Header.SUCCESS);
    public static final int API_RESULT_SUCCESS = 0;
    @NonNull
    private Header header;
    private T result;
    
    public ApiResult(@NonNull Header header, T result) {
        this.header = header;
        this.result = result;
    }

    private ApiResult(Header header) {
        this.header = header;
        this.result = null;
    }
    
    public static <T> ApiResult<T> success() {
        return SUCCESS_RESPONSE;
    }

    public static <T> ApiResult<T> success(String message) {
        return new ApiResult<>(new Header(true, message));
    }

    public static <T> ApiResult<T> success(T result) {
        return new ApiResult<>(Header.SUCCESS, result);
    }
    

    public static <T> ApiResult<T> fail(String message) {
        return new ApiResult<>(Header.error(message));
    }

    public static <T> ApiResult<T> fail(String message, T result) {
        return new ApiResult<>(Header.error(message), result);
    }

    public static <T> ApiResult<ContentWrapper<T>> content(T content) {
        return ApiResult.success(new ContentWrapper<>(content));
    }

    public static <T> ApiResult<ContentsWrapper<T>> contents(List<T> contents) {
        if (contents == null) {
            return ApiResult.success(ContentsWrapper.empty());
        }
        return ApiResult.success(new ContentsWrapper<>(contents.size(), contents));
    }

    public static <T> ApiResult<ContentsWrapper<T>> contents(long totalCount, List<T> contents) {
        return ApiResult.success(new ContentsWrapper<>(totalCount, contents));
    }

    @JsonIgnore
    public boolean isSuccessful() {
        return header.isSuccessful();
    }

    
    @Value
    public static class Header {
        public static final Header SUCCESS = new Header(true, "");
        
        @JsonProperty("isSuccessful")
        private boolean successful;
        @JsonInclude(NON_EMPTY)
        private String resultMessage;
        
        public Header(boolean successful, String resultMessage) {
            this.successful = successful;
            this.resultMessage = resultMessage;
        }
        
        public static Header error(String resultMessage) {
            return new Header(false, resultMessage);
        }
        
    }
}

