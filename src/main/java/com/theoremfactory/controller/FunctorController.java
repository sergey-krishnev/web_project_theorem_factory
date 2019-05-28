package com.theoremfactory.controller;


import com.theoremfactory.model.Functor;
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
public class FunctorController {

    private final BasicService<Functor> basicService;

    @Autowired
    public FunctorController(BasicService<Functor> basicService) {
        this.basicService = basicService;
    }

    @GetMapping(value = "/functors")
    public ResponseEntity<List<Functor>> get() {
        return ResponseEntity.ok(basicService.getAll());
    }

    @PostMapping(value = "/functors")
    public ResponseEntity<Functor> add(@Valid @RequestBody Functor functor) {
        return ResponseEntity.ok(basicService.save(functor));
    }

    @GetMapping(value = "/functors/{id}")
    public ResponseEntity<Functor> findById(@PathVariable Long id) {
        Optional<Functor> stock = basicService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/functors/{id}")
    public ResponseEntity<Functor> update(@PathVariable Long id, @Valid @RequestBody Functor functor) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(basicService.save(functor));
    }

    @DeleteMapping("/functors/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        basicService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
