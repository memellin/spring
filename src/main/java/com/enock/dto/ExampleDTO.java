package com.enock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record ExampleDTO(
        @JsonProperty("_id") Long id,
        @Length(min = 1, max = 5) @Pattern(regexp = "PG|SG|SF|PF|C") String position,
        @NotNull @NotBlank @Length(min = 3, max = 100) String name,
        @NotNull @NotBlank @Length(max = 6) String ppg
) {
}
