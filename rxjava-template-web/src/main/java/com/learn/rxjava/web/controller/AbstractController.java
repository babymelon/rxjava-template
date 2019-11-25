package com.learn.rxjava.web.controller;

import com.learn.rxjava.model.response.BaseResponse;

public abstract class AbstractController {
    public <R> BaseResponse<R> toBaseResponse(R data) {
        return BaseResponse.<R>builder().value(data).build();
    }
}
