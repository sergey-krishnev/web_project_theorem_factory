package com.theoremfactory.service;

import com.theoremfactory.dao.TemplateDao;
import com.theoremfactory.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateServiceImpl implements BasicService<Template> {

    private final TemplateDao templateDao;

    @Autowired
    public TemplateServiceImpl(TemplateDao templateDao) {
        this.templateDao = templateDao;
    }


    @Override
    public List<Template> getAll() {
        return templateDao.findAll();
    }

    @Override
    public Template save(Template entity) {
        return templateDao.save(entity);
    }

    @Override
    public Optional<Template> findById(Long id) {
        return templateDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        templateDao.deleteById(id);
    }
}
