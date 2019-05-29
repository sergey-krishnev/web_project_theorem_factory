package com.theoremfactory.controller;

import com.theoremfactory.model.Class;
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
public class ClassController {

    private final BasicService<Class> basicService;

    @Autowired
    public ClassController(BasicService<Class> basicService) {
        this.basicService = basicService;
    }

    @GetMapping(value = "/classes")
    public ResponseEntity<List<Class>> get() {
        return ResponseEntity.ok(basicService.getAll());
    }

    @PostMapping(value = "/classes")
    public ResponseEntity<Class> add(@Valid @RequestBody Class clazz) {
        return ResponseEntity.ok(basicService.save(clazz));
    }

    @GetMapping(value = "/classes/{id}")
    public ResponseEntity<Class> findById(@PathVariable Long id) {
        Optional<Class> stock = basicService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/classes/{id}")
    public ResponseEntity<Class> update(@PathVariable Long id, @Valid @RequestBody Class clazz) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(basicService.save(clazz));
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        basicService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
