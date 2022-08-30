package com.musinsa.pre.adapter.infra.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CacheEvictManager {

    private final CacheManager cacheManager;
    
    // 1분 간격으로 캐시 비우기
    @Scheduled(cron = "0 */1 * * * *")
    public void refreshCache() {
        for (String name : cacheManager.getCacheNames()) {
            Objects.requireNonNull(cacheManager.getCache(name)).clear();
        }
    }
}
