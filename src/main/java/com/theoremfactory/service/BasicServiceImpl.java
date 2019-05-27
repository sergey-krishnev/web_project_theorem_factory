package com.theoremfactory.service;

import com.theoremfactory.dao.BasicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BasicServiceImpl<T> implements BasicService<T> {

    private final BasicDao<T> basicDao;

    @Autowired
    public BasicServiceImpl(BasicDao<T> basicDao) {
        this.basicDao = basicDao;
    }

    @Override
    public List<T> getAll() {
        return basicDao.findAll();
    }

    @Override
    public T add(T entity) {
        return basicDao.save(entity);
    }
}
