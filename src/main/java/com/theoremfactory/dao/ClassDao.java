package com.theoremfactory.dao;

import com.theoremfactory.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassDao extends JpaRepository<Class, Long> {
}
