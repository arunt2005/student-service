package com.apps.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(nullable = false)
    private String name;

    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 100, message = "Age must be at most 100")
    @Column(nullable = false)
    private int age;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;
}
