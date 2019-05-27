package com.theoremfactory.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ClassProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "class_detail", joinColumns = { @JoinColumn(name = "class_property_id")},
            inverseJoinColumns = { @JoinColumn(name = "class_id")})
    private List<Class> classes = new ArrayList<>();

}
