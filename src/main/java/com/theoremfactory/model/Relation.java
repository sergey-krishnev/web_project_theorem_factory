package com.theoremfactory.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "relation_detail", joinColumns = { @JoinColumn(name = "relation_id")},
            inverseJoinColumns = { @JoinColumn(name = "relation_property_id")})
    private List<RelationProperty> relationProperties = new ArrayList<>();

}
