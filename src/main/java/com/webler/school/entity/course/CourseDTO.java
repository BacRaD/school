package com.webler.school.entity.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webler.school.entity.person.student.Student;
import com.webler.school.entity.person.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CourseDTO {
    private Long id;
    private String name;
    private Integer courseCode;

    public static Course createCourse(CourseDTO dto) {
        return Course.builder()
                .id(dto.getId())
                .name(dto.getName())
                .courseCode(dto.getCourseCode())
                .build();
    }

    public static CourseDTO createDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .courseCode(course.getCourseCode())
                .build();
    }
}
