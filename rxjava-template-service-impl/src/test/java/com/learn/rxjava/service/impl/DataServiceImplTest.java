package com.learn.rxjava.service.impl;

import com.learn.rxjava.model.entity.RegistrationForm;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.MockitoAnnotations.initMocks;

public class DataServiceImplTest {

    @InjectMocks
    private DataServiceImpl dataService;

    @Ignore
    @Test
    public void asd() {
//        RegistrationForm result = dataService.getData("id").toBlocking().value();
//        System.out.println(result);
    }

    @Before
    public void setUp() {
        initMocks(this);
    }
}
