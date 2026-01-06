package com.naver.autoconfig;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyExternalClient {
    private final MyApiProperties myApiProperties;

    public String callApi(String message) {
        return String.format("[API 호출 성공] URL: %s, KEP: %s, 메시지: %s",
                myApiProperties.getBaseUrl(), myApiProperties.getApiKey(), message);
    }
}
