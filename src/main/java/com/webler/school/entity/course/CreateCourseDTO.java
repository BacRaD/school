package com.webler.school.entity.course;

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

public class CreateCourseDTO {

    @NotBlank
    private String name;

    @Min(value = 1, message = "A szám legyen nagyobb mint 0.")
    @Max(value = Integer.MAX_VALUE, message = "A szám nem lehet nagyobb mint " + Integer.MAX_VALUE)
    private Integer courseCode;

    public static Course crateCourse(CreateCourseDTO dto) {
        return Course.builder()
                .name(dto.getName())
                .courseCode(dto.getCourseCode())
                .build();
    }
}
