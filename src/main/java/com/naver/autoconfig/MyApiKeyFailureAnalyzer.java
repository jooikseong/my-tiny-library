package com.naver.autoconfig;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class MyApiKeyFailureAnalyzer extends AbstractFailureAnalyzer<ApiKeyNotFoundException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, ApiKeyNotFoundException cause) {
        return new FailureAnalysis(
                "MyApi 라이브러리의 API Key가 누락되었습니다.",
                "application.yml 또는 application.properties에 'my.api.api-key' 값을 설정하세요.",
                cause
        );
    }
}
