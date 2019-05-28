package com.theoremfactory.service;

import java.util.List;
import java.util.Optional;

public interface BasicService<T> {

    List<T> getAll();

    T save(T entity);

    Optional<T> findById(Long id);

    void deleteById(Long id);
}
