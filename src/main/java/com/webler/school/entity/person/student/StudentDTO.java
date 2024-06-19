package com.webler.school.entity.person.student;

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

public class StudentDTO {
    private Long id;
    private String name;
    private Integer age;
    private String address;

    private List<Course> courses;

    public static StudentDTO createDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .address(student.getAddress())
                .courses(student.getCourses())
                .build();
    }

    public static Student createStudent(StudentDTO dto) {
        return Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .address(dto.getAddress())
                .courses(dto.getCourses())
                .build();
    }
}
