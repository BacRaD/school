package com.webler.school.entity.grades;

import com.webler.school.entity.course.Course;
import com.webler.school.entity.person.student.Student;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class GradeDTO {
    private Long id;
    private String date;

    @Min(value = 1, message = "Min 1, max 5.")
    @Max(value = 5, message = "Min 1, max 5.")
    private Integer grade;
    private Student student;
    private Course course;

    public static GradeDTO createDto(Grade grade) {
        return GradeDTO.builder()
                .id(grade.getId())
                .date(grade.getDate())
                .grade(grade.getGrade())
                .student(grade.getStudent())
                .course(grade.getCourse())
                .build();
    }

    public static Grade createGrade(GradeDTO dto) {
        return Grade.builder()
                .id(dto.getId())
                .date(dto.getDate())
                .grade(dto.getGrade())
                .student(dto.getStudent())
                .course(dto.getCourse())
                .build();
    }
}
