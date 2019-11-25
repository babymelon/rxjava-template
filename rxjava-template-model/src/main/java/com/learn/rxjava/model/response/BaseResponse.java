package com.learn.rxjava.model.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class BaseResponse<R> implements Serializable {

    private String code;
    private String message;
    private boolean success = true;
    private R value;
}
