package com.enock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@SQLDelete(sql = "UPDATE  Example SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Length(min = 1, max = 5)
    @Pattern(regexp = "PG|SG|SF|PF|C")
    @Column(nullable = true, length = 10, name = "position")
    private String position;

    @NotNull
    @NotBlank
    @Length(min = 3, max = 100)
    @Column(nullable = false, length = 200, name = "name")
    private String name;

    @NotNull
    @Length(max=6)
    @Column(length = 6)
    private String ppg; // points per game, talvez mudar para float

    @NotNull
    @Length(max=10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";

}
