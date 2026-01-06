package com.naver.autoconfig;

public class ApiKeyNotFoundException extends RuntimeException {
    public ApiKeyNotFoundException() {
        super("API Key가 설정되지 않았습니다.");
    }
}
