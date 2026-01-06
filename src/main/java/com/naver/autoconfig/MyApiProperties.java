package com.naver.autoconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter@Setter
@ConfigurationProperties(prefix = "my.api")
public class MyApiProperties {
    private String apiKey;
    private String baseUrl = "https://api.default.com";
    private boolean enabled = true;
    private int timeout = 5000;
}
