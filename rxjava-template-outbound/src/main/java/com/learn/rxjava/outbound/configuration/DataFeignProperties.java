package com.learn.rxjava.outbound.configuration;

import feign.Logger;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Data
@Configuration
@ConfigurationProperties(prefix = "feign.data")
public class DataFeignProperties {
    private Long connectTimeout = 2000L;
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    private Long readTimeout = 2000L;
    private Logger.Level level = Logger.Level.BASIC;
}
