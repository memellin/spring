package com.enock.service;

import com.enock.exception.RecordNotFoundException;
import com.enock.model.Example;
import com.enock.respository.ExampleRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Validated
@Service
public class ExampleService {

    private final ExampleRepository exampleRepository;


    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public List<Example> getExamples() {
        return exampleRepository.findAll();
    }
    public Example findById(@PathVariable("id") @NotNull @Positive Long Id){
        return exampleRepository.findById(Id).orElseThrow(() -> new RecordNotFoundException(Id));
    }

    public Example create(@Valid Example example){
        return exampleRepository.save(example);
    }

    public Example update(@PathVariable("id")  @NotNull @Positive Long identificador, @Valid Example example){
        return exampleRepository.findById(identificador)
                .map(record ->{
                    record.setName(example.getName());
                    record.setPpg(example.getPpg());
                    return exampleRepository.save(record);
                }).orElseThrow(() -> new RecordNotFoundException(identificador));
    }

    public void delete(@PathVariable("id") @NotNull @Positive Long id){

        exampleRepository.delete(exampleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));


    }
}
