package com.theoremfactory.controller;

import com.theoremfactory.model.Tmodel;
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
public class TmodelController {

    private final BasicService<Tmodel> basicService;

    @Autowired
    public TmodelController(BasicService<Tmodel> basicService) {
        this.basicService = basicService;
    }

    @GetMapping(value = "/tmodels")
    public ResponseEntity<List<Tmodel>> get() {
        return ResponseEntity.ok(basicService.getAll());
    }

    @PostMapping(value = "/tmodels")
    public ResponseEntity<Tmodel> add(@Valid @RequestBody Tmodel tmodel) {
        return ResponseEntity.ok(basicService.save(tmodel));
    }

    @GetMapping(value = "/tmodels/{id}")
    public ResponseEntity<Tmodel> findById(@PathVariable Long id) {
        Optional<Tmodel> stock = basicService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/tmodels/{id}")
    public ResponseEntity<Tmodel> update(@PathVariable Long id, @Valid @RequestBody Tmodel tmodel) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(basicService.save(tmodel));
    }

    @DeleteMapping("/tmodels/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        basicService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
