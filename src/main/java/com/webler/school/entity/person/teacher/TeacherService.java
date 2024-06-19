package com.webler.school.entity.person.teacher;

import com.webler.school.entity.course.Course;
import com.webler.school.entity.course.CourseDTO;
import com.webler.school.entity.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private CourseService courseService;


    public TeacherDTO get(Long id) {

        return TeacherDTO.createDto(repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen tanár", new Exception())));
    }

    public List<TeacherDTO> list() {

        return repository.findAll().stream().map(TeacherDTO::createDto).collect(Collectors.toList());
    }

    public TeacherDTO create(CreateTeacherDTO dto) {
        return TeacherDTO.createDto(repository.save(CreateTeacherDTO.createTeacher(dto)));
    }

    public TeacherDTO update(TeacherDTO dto, Long id) {
        Teacher teacher = TeacherDTO.createTeacher(dto);
        teacher.setId(id);
        return TeacherDTO.createDto(repository.save(teacher));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public TeacherDTO addCourse(Long id, Long courseId) {
        Course course = CourseDTO.createCourse(courseService.get(courseId));
        Teacher teacher = TeacherDTO.createTeacher(get(id));
        List<Course> courses = teacher.getCourses();
        courses.add(course);
        teacher.setCourses(courses);

        return TeacherDTO.createDto(repository.save(teacher));
    }
}
