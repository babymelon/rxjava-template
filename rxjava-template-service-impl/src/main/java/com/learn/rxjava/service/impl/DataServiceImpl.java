package com.learn.rxjava.service.impl;

import com.learn.rxjava.model.entity.RegistrationForm;
import com.learn.rxjava.outbound.feign.DataFeign;
import com.learn.rxjava.service.DataService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Single;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataFeign dataFeign;

    @Override
    public Single<String> getData(String id) {
        return dataFeign.getData(id).map(result -> {
            if (result == null) {
                return "EMPTY";
            }
            return "SUCCESS";
        });
    }

    @Override
    public Single<Boolean> saveData(RegistrationForm registrationForm) {
        return null;
    }
}
