package com.theoremfactory.service;

import com.theoremfactory.dao.TmodelDao;
import com.theoremfactory.model.Tmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TmodelServiceImpl implements BasicService<Tmodel> {

    private final TmodelDao tmodelDao;

    @Autowired
    public TmodelServiceImpl(TmodelDao tmodelDao) {
        this.tmodelDao = tmodelDao;
    }

    @Override
    public List<Tmodel> getAll() {
        return tmodelDao.findAll();
    }

    @Override
    public Tmodel save(Tmodel entity) {
        return tmodelDao.save(entity);
    }

    @Override
    public Optional<Tmodel> findById(Long id) {
        return tmodelDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        tmodelDao.deleteById(id);
    }
}
