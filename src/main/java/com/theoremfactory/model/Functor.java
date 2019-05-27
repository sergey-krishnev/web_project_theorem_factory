package com.theoremfactory.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Functor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "functor_detail", joinColumns = { @JoinColumn(name = "functor_id")},
            inverseJoinColumns = { @JoinColumn(name = "functor_property_id")})
    private List<FunctorProperty> functorProperties = new ArrayList<>();

}
