package com.webler.school.entity.person.student;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateStudentDTO {

    @NotBlank(message = "Add meg a teljes neved")
    private String name;

    @Min(value = 14, message = "Csak 14. életévüket betöltöttek tanulhatnak itt.")
    @Max(value = 99, message = "Nem vagy már túl idős ehhez?")
    private Integer age;

    @NotBlank(message = "Add meg a címed")
    private String address;

    public static Student createStudent(CreateStudentDTO dto) {
        return Student.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .address(dto.getAddress())
                .build();
    }
}
