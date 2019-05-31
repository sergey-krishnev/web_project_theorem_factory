package com.theoremfactory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String content;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tmodel_detail", joinColumns = { @JoinColumn(name = "template_id")},
            inverseJoinColumns = { @JoinColumn(name = "tmodel_id")})
    @JsonIgnore
    private List<Tmodel> tmodels = new ArrayList<>();

}
