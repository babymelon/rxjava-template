package com.learn.rxjava.outbound.configuration;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractFallbackFactory<R> implements FallbackFactory<R> {

    @Override
    public R create(Throwable throwable) {
        log.error("Error invoke feign {}", throwable);
        return doCreate(throwable);
    }

    public abstract R doCreate(Throwable throwable);
}
