package com.theoremfactory.controller;

import com.theoremfactory.model.Template;
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
public class TemplateController {

    private final BasicService<Template> basicService;

    @Autowired
    public TemplateController(BasicService<Template> basicService) {
        this.basicService = basicService;
    }

    @GetMapping(value = "/templates")
    public ResponseEntity<List<Template>> get() {
        return ResponseEntity.ok(basicService.getAll());
    }

    @PostMapping(value = "/templates")
    public ResponseEntity<Template> add(@Valid @RequestBody Template template) {
        return ResponseEntity.ok(basicService.save(template));
    }

    @GetMapping(value = "/templates/{id}")
    public ResponseEntity<Template> findById(@PathVariable Long id) {
        Optional<Template> stock = basicService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/templates/{id}")
    public ResponseEntity<Template> update(@PathVariable Long id, @Valid @RequestBody Template template) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(basicService.save(template));
    }

    @DeleteMapping("/templates/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!basicService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        basicService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
