package com.naver.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyApiProperties.class)
@ConditionalOnProperty(prefix = "my.api", name = "enabled", havingValue = "true") // 특정 조건일 때만 빈 등록
public class MyApiAutoConfiguration {

    @Bean
    public MyExternalClient myExternalClient(MyApiProperties properties) {
        if (properties.getApiKey() == null || properties.getApiKey().isEmpty()) {
            throw new ApiKeyNotFoundException();
        }
        return new MyExternalClient(properties);
    }
}
