package com.theoremfactory.service;

import com.theoremfactory.dao.RelationDao;
import com.theoremfactory.model.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationServiceImpl implements BasicService<Relation> {

    private final RelationDao relationDao;

    @Autowired
    public RelationServiceImpl(RelationDao relationDao) {
        this.relationDao = relationDao;
    }

    @Override
    public List<Relation> getAll() {
        return relationDao.findAll();
    }

    @Override
    public Relation save(Relation entity) {
        return relationDao.save(entity);
    }

    @Override
    public Optional<Relation> findById(Long id) {
        return relationDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        relationDao.deleteById(id);
    }
}
