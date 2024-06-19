package com.webler.school.entity.grades;

import com.webler.school.entity.course.Course;
import com.webler.school.entity.course.CourseService;
import com.webler.school.entity.course.CourseDTO;
import com.webler.school.entity.person.student.Student;
import com.webler.school.entity.person.student.StudentDTO;
import com.webler.school.entity.person.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GradeService {

    @Autowired
    private GradeRepository repository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    public List<GradeDTO> list() {
        List<Grade> grades = repository.findAll();
        return grades.stream().map(GradeDTO::createDto).collect(Collectors.toList());
    }

    public GradeDTO get(Long id) {
        return GradeDTO.createDto(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nem található", new Exception())));
    }

    public GradeDTO create(CreateGradeDTO dto, Long studentId, Long courseId) {

        Student student = StudentDTO.createStudent(studentService.get(studentId));
        Course course = CourseDTO.createCourse(courseService.get(courseId));

        if(!student.getCourses().contains(course)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " A tanuló nincs jelentkezve a kurzusra");
        }

        Grade grade = CreateGradeDTO.createGrade(dto);

        grade.setStudent(student);
        grade.setCourse(course);

        return GradeDTO.createDto(repository.save(grade));
    }

    public GradeDTO update(GradeDTO dto, Long id) {

        Grade grade = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A jegy nem létezik."));

        grade.setId(id);
        grade.setGrade(dto.getGrade());

        return GradeDTO.createDto(repository.save(grade));
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "A jegy nem létezik"));
        repository.deleteById(id);
    }

    public List<AvgDTO> listStudentByGradeAvg() {
        return repository.listStudentByGradeAvg();
    }
}
