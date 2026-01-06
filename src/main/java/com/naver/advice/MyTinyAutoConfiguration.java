package com.naver.advice;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(MyTinyProperties.class)
public class MyTinyAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ResponseBodyAdvice responseBodyAdvice() {
        return new ResponseBodyAdvice();
    }
}
