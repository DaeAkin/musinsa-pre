package com.musinsa.pre.adapter.mvc;

import com.musinsa.pre.adapter.common.api.ApiResult;
import com.musinsa.pre.domain.common.MusinsaCommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalRestControllerAdvice {

    @ExceptionHandler(MusinsaCommonException.class)
    public ResponseEntity<ApiResult> handleException(Exception cause) {
        log.error("exception occur : {} ", cause);
        return ResponseEntity.ok(ApiResult.fail(cause.getMessage()));
    }
}
