package com.theoremfactory.controller;

import com.theoremfactory.model.Relation;
import com.theoremfactory.service.BasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class RelationController {

    private final BasicService<Relation> basicService;

    @Autowired
    public RelationController(BasicService<Relation> basicService) {
        this.basicService = basicService;
    }

    @GetMapping(value = "/relations")
    public ResponseEntity<List<Relation>> get() {
        return ResponseEntity.ok(basicService.getAll());
    }

    @PostMapping(value = "/relations")
    public ResponseEntity<Relation> add(@Valid @RequestBody Relation relation) {
        return ResponseEntity.ok(basicService.save(relation));
    }

    @GetMapping(value = "/relations/{id}")
    public ResponseEntity<Relation> findById(@PathVariable Long id) {
        Optional<Relation> stock = basicService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/relations/{id}")
    public ResponseEntity<Relation> update(@PathVariable Long id, @Valid @RequestBody Relation relation) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
           return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(basicService.save(relation));
    }

    @DeleteMapping("/relations/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        basicService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
