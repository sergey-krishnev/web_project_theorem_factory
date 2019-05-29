package com.theoremfactory.dao;

import com.theoremfactory.model.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationDao extends JpaRepository<Relation, Long> {
}
