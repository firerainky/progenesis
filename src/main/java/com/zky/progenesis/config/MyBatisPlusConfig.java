package com.zky.progenesis.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zky.progenesis.config.properties.TenantProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({TenantProperties.class})
public class MyBatisPlusConfig {
    
}
