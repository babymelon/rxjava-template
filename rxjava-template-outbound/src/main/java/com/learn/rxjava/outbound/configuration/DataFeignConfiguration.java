package com.learn.rxjava.outbound.configuration;

import feign.Logger;
import feign.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class DataFeignConfiguration {
    @Autowired
    private DataFeignProperties dataFeignProperties;

    @Bean
    public Request.Options options() {
        return new Request.Options(
            (int) dataFeignProperties.getTimeUnit().toMillis(dataFeignProperties.getConnectTimeout()),
            (int) dataFeignProperties.getTimeUnit().toMillis(dataFeignProperties.getReadTimeout()));
    }

    @Bean
    public Logger.Level level() {
        return dataFeignProperties.getLevel();
    }
}
