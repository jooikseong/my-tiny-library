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

//    public String getApiKey() { return apiKey; }
//    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
//
//    public String getBaseUrl() { return baseUrl; }
//    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
//
//    public boolean isEnabled() { return enabled; }
//    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
