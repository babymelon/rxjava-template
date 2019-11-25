package com.learn.rxjava.web.controller;

import com.learn.rxjava.model.entity.RegistrationForm;
import com.learn.rxjava.model.response.BaseResponse;
import com.learn.rxjava.service.DataService;
import com.learn.rxjava.web.helper.DeferredSubscriber;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController extends AbstractController{

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public DeferredResult<BaseResponse<String>> getOne(@RequestParam("id") String id) {
        DeferredResult<BaseResponse<String>> result = new DeferredResult<>();
        this.dataService.getData(id)
            .map(data -> this.toBaseResponse(data))
            .subscribe(new DeferredSubscriber<>(result));

        return result;
    }
}