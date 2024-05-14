package com.zky.progenesis.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zky.progenesis.config.properties.TenantProperties;

// https://blog.csdn.net/tianmaxingkonger/article/details/128719327?spm=1001.2101.3001.6650.7&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-7-128719327-blog-135595218.235%5Ev43%5Epc_blog_bottom_relevance_base1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-7-128719327-blog-135595218.235%5Ev43%5Epc_blog_bottom_relevance_base1&utm_relevant_index=13

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({TenantProperties.class})
public class MyBatisPlusConfig {
    
}
