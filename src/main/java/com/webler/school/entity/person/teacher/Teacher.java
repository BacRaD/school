package com.webler.school.entity.person.teacher;

import com.webler.school.entity.course.Course;
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
@Table(name = "TEACHERS")

public class Teacher extends Person {

    @OneToMany
    @JoinColumn(name = "teachers_id")
    private List<Course> courses;
}
