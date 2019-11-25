package com.learn.rxjava.outbound.feign;

import com.learn.rxjava.model.entity.RegistrationForm;
import com.learn.rxjava.outbound.configuration.DataFeignConfiguration;
import com.learn.rxjava.outbound.fallback.DataFeignFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rx.Single;

@FeignClient(name = "dataFeign",
    url = "${service.data.endpoint}",
    fallbackFactory = DataFeignFallbackFactory.class,
    configuration = DataFeignConfiguration.class)
public interface DataFeign {

    @RequestMapping(value = "/api/example/findById", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Single<RegistrationForm> getData(@RequestParam("id") String id);
}
