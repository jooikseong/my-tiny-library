package com.naver;

import com.naver.autoconfig.MyApiAutoConfiguration;
import com.naver.autoconfig.MyApiProperties;
import com.naver.autoconfig.MyExternalClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class MyApiAutoConfigurationTest {

    // 1. 테스트를 도와줄 러너 생성 (내가 만든 자동 설정 클래스를 등록)
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(MyApiAutoConfiguration.class);

    @Test
    void 설정값이_없으면_빈이_생성되지_않아야_한다() {
        this.contextRunner
                .withPropertyValues("my.api.enabled=false")
                .run(context -> {
                    // MyExternalClient 빈이 있는지 확인
                    assertThat(context).doesNotHaveBean(MyExternalClient.class);
                });
    }

    @Test
    void 설정값이_있으면_빈이_정상적으로_생성되어야_한다() {
        this.contextRunner
                .withPropertyValues(
                        "my.api.enabled=true",
                        "my.api.api-key=test-key",
                        "my.api.base-url=https://naver.com"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(MyExternalClient.class);
                    String result = context.getBean(MyExternalClient.class).callApi("Hello");
                    assertThat(result).contains("test-key");
                    assertThat(result).contains("https://naver.com");
                });
    }

    @Test
    void 사용자가_직접_빈을_등록하면_라이브러리_빈은_무시되어야_한다() {
        // ConditionalOnMissingBean 테스트
        this.contextRunner
                .withUserConfiguration(UserCustomConfig.class)
                .run(context -> {
                    assertThat(context).hasSingleBean(MyExternalClient.class);

                    String result = context.getBean(MyExternalClient.class).callApi("Hello");

                    assertThat(result).contains("custom-key");
                });
    }

    static class UserCustomConfig {
        @Bean
        public MyExternalClient myExternalClient() {
            MyApiProperties properties = new MyApiProperties();
            properties.setApiKey("custom-key");
            properties.setBaseUrl("http://custom.com");
            return new MyExternalClient(properties);
        }
    }

}
