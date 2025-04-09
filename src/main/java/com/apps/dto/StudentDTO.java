package com.apps.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class StudentDTO {

    @Null(message = "ID must be null for new students")
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 100, message = "Age must be at most 100")
    private int age;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be valid")
    private String email;
}
