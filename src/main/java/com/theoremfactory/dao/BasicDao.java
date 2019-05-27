package com.theoremfactory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicDao<T> extends JpaRepository<T, Long> {

}
