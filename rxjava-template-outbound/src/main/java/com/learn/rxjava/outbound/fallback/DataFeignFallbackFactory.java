package com.learn.rxjava.outbound.fallback;

import com.learn.rxjava.outbound.feign.DataFeign;
import com.learn.rxjava.outbound.configuration.AbstractFallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataFeignFallbackFactory extends AbstractFallbackFactory<DataFeign> {

    @Autowired
    private DataFeignFallback fallback;

    @Override
    public DataFeign doCreate(Throwable throwable) {
        return fallback;
    }
}
