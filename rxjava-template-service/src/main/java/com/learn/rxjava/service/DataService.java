package com.learn.rxjava.service;

import com.learn.rxjava.model.entity.RegistrationForm;
import rx.Single;

public interface DataService {
    Single<String> getData(String id);

    Single<Boolean> saveData(RegistrationForm registrationForm);
}
