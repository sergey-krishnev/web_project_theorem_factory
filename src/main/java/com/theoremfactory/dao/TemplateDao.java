package com.theoremfactory.dao;

import com.theoremfactory.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateDao extends JpaRepository<Template, Long> {
}
