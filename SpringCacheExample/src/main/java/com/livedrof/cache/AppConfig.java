package com.livedrof.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 */
@Configuration
@ComponentScan(basePackages = "com.livedrof.service")
@EnableCaching(proxyTargetClass = true)
public class AppConfig implements CachingConfigurer {
    @Bean
    public CacheManager cacheManager() {
        try {
            net.sf.ehcache.CacheManager ehcacheCacheManager = new net.sf.ehcache.CacheManager(new ClassPathResource("ehcache.xml").getInputStream());
            EhCacheCacheManager cacheCacheManager = new EhCacheCacheManager(ehcacheCacheManager);
            return cacheCacheManager;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CacheResolver cacheResolver() {
        return null;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    public CacheErrorHandler errorHandler() {
        return null;
    }
}