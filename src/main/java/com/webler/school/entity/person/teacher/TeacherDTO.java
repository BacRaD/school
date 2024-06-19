package com.webler.school.entity.person.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webler.school.entity.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TeacherDTO {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private List<Course> courses;

    public static Teacher createTeacher(TeacherDTO dto) {
        return Teacher.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .address(dto.getAddress())
                .courses(dto.getCourses())
                .build();
    }

    public static TeacherDTO createDto(Teacher teacher) {
        return TeacherDTO.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .age(teacher.getAge())
                .address(teacher.getAddress())
                .courses(teacher.getCourses())
                .build();
    }
}
