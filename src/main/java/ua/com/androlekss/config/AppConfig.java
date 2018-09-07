package ua.com.androlekss.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
@EnableCaching
public class AppConfig extends CachingConfigurerSupport {


     @Bean
     @Override
     public CacheManager cacheManager() {

         SimpleCacheManager cacheManager = new SimpleCacheManager();
         cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("contactsCache")));
         return cacheManager;
     }

     @Bean
     @Override
     public KeyGenerator keyGenerator() {

         return new KeyGenerator(){

             @Override
             public Object generate(Object o, Method method, Object... objects) {
                 StringBuilder sb = new StringBuilder();
                 sb.append(o.getClass().getName());
                 sb.append(method.getName());
                 for(Object obj: objects){
                     sb.append(obj.toString());
                 }
                 return sb.toString();
             }
         };
     }
 }