package com.learn.rxjava.outbound.fallback;

import com.learn.rxjava.model.entity.RegistrationForm;
import com.learn.rxjava.outbound.feign.DataFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import rx.Single;

@Component
public class DataFeignFallback implements DataFeign {

    @Override
    public Single<RegistrationForm> getData(@RequestParam("id") String id) {
        return Single.just(new RegistrationForm());
    }
}
