package com.webler.school.entity.course;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webler.school.entity.grades.Grade;
import com.webler.school.entity.person.student.Student;
import com.webler.school.entity.person.teacher.Teacher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Data
@EqualsAndHashCode(exclude = {"grades"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false, unique = true)
    private Integer courseCode;

    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private List<Grade> grades;
}