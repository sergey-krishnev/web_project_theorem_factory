package com.theoremfactory.service;

import com.theoremfactory.dao.ClassDao;
import com.theoremfactory.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements BasicService<Class> {

    private final ClassDao classDao;

    @Autowired
    public ClassServiceImpl(ClassDao functorDao) {
        this.classDao = functorDao;
    }

    @Override
    public List<Class> getAll() {
        return classDao.findAll();
    }

    @Override
    public Class save(Class entity) {
        return classDao.save(entity);
    }

    @Override
    public Optional<Class> findById(Long id) {
        return classDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        classDao.deleteById(id);
    }
}
