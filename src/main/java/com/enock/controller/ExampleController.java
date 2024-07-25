package com.enock.controller;

import java.util.List;

import com.enock.service.ExampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.enock.model.Example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/examples")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    // @RequestMapping is used to map web requests to particular handler classes or
    // methods
    @GetMapping
    public @ResponseBody List<Example> getExamples() {
        return exampleService.getExamples();
    }

    @GetMapping("/{id}")
    public Example findById(@PathVariable("id") @NotNull @Positive Long Id){
        return exampleService.findById(Id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Example create(@RequestBody  @Valid Example example){
        return exampleService.create(example);
    }

    @PutMapping("/{id}")
    public Example update(@PathVariable("id") @NotNull @Positive Long identificador, @RequestBody  @Valid Example example){
        return exampleService.update(identificador, example);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull @Positive Long id) {
        exampleService.delete(id);
    }

}

