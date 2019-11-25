package com.learn.rxjava.web.helper;

import org.springframework.web.context.request.async.DeferredResult;
import rx.Subscriber;

public class DeferredSubscriber<R> extends Subscriber<R> {
    private DeferredResult<R> result;

    public DeferredSubscriber(DeferredResult<R> result) {
        this.result = result;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable throwable) {
        result.setErrorResult(throwable);
    }

    @Override
    public void onNext(R object) {
        result.setResult(object);
    }
}
