package com.learn.rxjava.web.helper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public abstract class BeanMapper {

    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private static MapperFacade mapper = mapperFactory.getMapperFacade();

    public static <S, D> D map(S source, Class<D> clazz) {
        return mapper.map(source, clazz);
    }

    public static <S, D> List<D> mapAsList(Iterable<S> source, Class<D> clazz) {
        return mapper.mapAsList(source, clazz);
    }
}
