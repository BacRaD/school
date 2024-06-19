package com.webler.school.entity.person.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webler.school.entity.course.Course;
import com.webler.school.entity.grades.Grade;
import com.webler.school.entity.person.Person;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Student extends Person {

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private List<Course> courses;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "grade_id")
    private List<Grade> grades;
}
