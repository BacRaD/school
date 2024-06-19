package com.webler.school.entity.person.teacher;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateTeacherDTO {

    @NotBlank(message = "Add meg a teljes neved")
    private String name;

    @Min(value = 21, message = "Csak 21. életévüket betöltöttek taníthatnak itt.")
    @Max(value = 99, message = "Nem vagy már túl idős ehhez?")
    private Integer age;

    @NotBlank(message = "Add meg a címed")
    private String address;

    public static Teacher createTeacher(CreateTeacherDTO dto) {
        return Teacher.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .address(dto.getAddress())
                .build();
    }
}
