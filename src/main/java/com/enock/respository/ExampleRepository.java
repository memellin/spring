package com.enock.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enock.model.Example;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Long>{

    
}
