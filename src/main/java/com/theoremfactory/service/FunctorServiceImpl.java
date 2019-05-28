package com.theoremfactory.service;

import com.theoremfactory.dao.FunctorDao;
import com.theoremfactory.model.Functor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FunctorServiceImpl implements BasicService<Functor> {

    private final FunctorDao functorDao;

    @Autowired
    public FunctorServiceImpl(FunctorDao functorDao) {
        this.functorDao = functorDao;
    }

    @Override
    public List<Functor> getAll() {
        return functorDao.findAll();
    }

    @Override
    public Functor save(Functor entity) {
        return functorDao.save(entity);
    }

    @Override
    public Optional<Functor> findById(Long id) {
        return functorDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        functorDao.deleteById(id);
    }
}
