package com.chegy.hrserverplus.config;

import org.springframework.cache.annotation.*;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        /**
         * 使用类名 + 方法名 + 参数作为缓存key
         * @return
         */
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
        /**
         * 缓存key按照 缓存名称 + id的方式
         */
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                String[] value = new String[1];
//                Cacheable cacheable = method.getAnnotation(Cacheable.class);
//                if (cacheable != null) {
//                    value = cacheable.value();
//                }
//                CachePut cachePut = method.getAnnotation(CachePut.class);
//                if (cachePut != null) {
//                    value = cachePut.value();
//                }
//                CacheEvict cacheEvict = method.getAnnotation(CacheEvict.class);
//                if (cacheEvict != null) {
//                    value = cacheEvict.value();
//                }
//                sb.append(value[0]);
//                for (Object obj : params) {
//                    sb.append(":")
//                            .append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };

    }
}
