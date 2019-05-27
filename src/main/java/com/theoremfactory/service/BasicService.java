package com.theoremfactory.service;

import java.util.List;

public interface BasicService<T> {

    List<T> getAll();

    T add(T entity);

}
