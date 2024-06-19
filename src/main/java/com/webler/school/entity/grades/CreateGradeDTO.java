package com.webler.school.entity.grades;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateGradeDTO {


    private String date;

    @Min(value = 1, message = "Min 1, max 5.")
    @Max(value = 5, message = "Min 1, max 5.")
    private Integer grade;

    public static Grade createGrade(CreateGradeDTO dto) {

        return Grade.builder()
                .date(dto.getDate())
                .grade(dto.getGrade())
                .build();
    }
}
