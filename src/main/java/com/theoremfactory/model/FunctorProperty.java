package com.theoremfactory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class FunctorProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "functor_detail", joinColumns = { @JoinColumn(name = "functor_property_id")},
            inverseJoinColumns = { @JoinColumn(name = "functor_id")})
    @JsonIgnore
    private List<Functor> functors = new ArrayList<>();

    public FunctorProperty() {
    }

    public FunctorProperty(@NotNull String name) {
        this.name = name;
    }
}
