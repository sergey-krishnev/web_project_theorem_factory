package com.theoremfactory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class RelationProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "relation_detail", joinColumns = { @JoinColumn(name = "relation_property_id")},
            inverseJoinColumns = { @JoinColumn(name = "relation_id")})
    @JsonIgnore
    private List<Relation> relations = new ArrayList<>();

}
