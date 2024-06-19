package com.webler.school.entity.course;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("course")

public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> list() {

        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> get(@PathVariable Long id) {

        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CreateCourseDTO dto) {

        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@RequestBody CourseDTO dto, @PathVariable Long id) {

       return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.NOT_FOUND;
        }
    }
}
