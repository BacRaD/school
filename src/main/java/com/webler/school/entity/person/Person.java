package com.webler.school.entity.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass

public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Add meg a teljes neved")
    @Column(name = "NAME", nullable = false)
    private String name;

    @Min(value = 14, message = "Csak 14. életévüket betöltöttek tanulhatnak itt.")
    @Max(value = 99, message = "Nem vagy már túl idős ehhez?")
    @Column(name = "AGE", nullable = false)
    private Integer age;

    @NotBlank(message = "Add meg a címed")
    @Column(name = "ADDRESS", nullable = false)
    private String address;
}
