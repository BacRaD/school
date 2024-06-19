package com.webler.school.entity.course;

import com.webler.school.entity.grades.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;
    private GradeService gradeService;

    public List<CourseDTO> list() {
        return repository.findAll().stream().map(CourseDTO::createDTO).collect(Collectors.toList());
    }

    public CourseDTO get(Long id) {
        return CourseDTO.createDTO(repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen kurzus", new Exception())));
    }

    public CourseDTO create(CreateCourseDTO dto) {
        Course course = repository.save(CreateCourseDTO.crateCourse(dto));
        return CourseDTO.createDTO(course);
    }

    public CourseDTO update(CourseDTO dto, Long id) {
        Course course = CourseDTO.createCourse(dto);
        course.setId(id);
        return CourseDTO.createDTO(repository.save(course));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
