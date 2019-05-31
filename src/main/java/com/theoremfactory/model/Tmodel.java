package com.theoremfactory.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Tmodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tmodel_functor_detail", joinColumns = { @JoinColumn(name = "tmodel_id")},
            inverseJoinColumns = { @JoinColumn(name = "functor_property_id")})
    private List<FunctorProperty> functorProperties = new ArrayList<>();

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tmodel_relation_detail", joinColumns = { @JoinColumn(name = "tmodel_id")},
            inverseJoinColumns = { @JoinColumn(name = "relation_property_id")})
    private List<RelationProperty> relationProperties = new ArrayList<>();

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tmodel_class_detail", joinColumns = { @JoinColumn(name = "tmodel_id")},
            inverseJoinColumns = { @JoinColumn(name = "class_property_id")})
    private List<ClassProperty> classProperties = new ArrayList<>();

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tmodel_detail", joinColumns = { @JoinColumn(name = "tmodel_id")},
            inverseJoinColumns = { @JoinColumn(name = "template_id")})
    private List<Template> templates = new ArrayList<>();

}
