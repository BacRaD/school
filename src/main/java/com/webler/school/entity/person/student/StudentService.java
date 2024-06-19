package com.webler.school.entity.person.student;

import com.webler.school.entity.course.Course;
import com.webler.school.entity.course.CourseDTO;
import com.webler.school.entity.course.CourseService;
import com.webler.school.entity.grades.Grade;
import com.webler.school.entity.grades.GradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private CourseService courseService;

    public StudentDTO get(Long id) {
        return StudentDTO.createDTO(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen tanuló", new Exception())));
    }

    public List<StudentDTO> list() {
        return repository.findAll().stream().map(StudentDTO::createDTO).collect(Collectors.toList());
    }

    public StudentDTO create(CreateStudentDTO dto) {

        if (dto.getName() == null || dto.getAge() == null || dto.getAddress() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Üres mező", new Exception());
        }
        return StudentDTO.createDTO(repository.save(CreateStudentDTO.createStudent(dto)));
    }

    public StudentDTO update(StudentDTO dto, Long id) {
        Student student = StudentDTO.createStudent(dto);
        student.setId(id);
        return StudentDTO.createDTO(repository.save(student));
    }

    public StudentDTO addCourse(Long id, Long courseId) {
        Course course = CourseDTO.createCourse(courseService.get(courseId));
        Student student = StudentDTO.createStudent(get(id));
        List<Course> courses = student.getCourses();
        courses.add(course);
        student.setCourses(courses);

        return StudentDTO.createDTO(repository.save(student));
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (ResponseStatusException e) {
            e.printStackTrace();
        }
    }
}
