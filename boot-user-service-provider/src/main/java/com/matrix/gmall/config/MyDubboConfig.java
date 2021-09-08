package com.matrix.gmall.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 对应provider.xml中的配置
 */
@Configuration
public class MyDubboConfig {
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("user-service-provider");
        // return出去 @Bean放到容器中去
        return applicationConfig;
    }
}
