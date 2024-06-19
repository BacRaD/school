package com.webler.school.entity.person.teacher;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("teacher")

public class TeacherController {

    @Autowired
    private TeacherService service;

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> list() {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> create(@Valid @RequestBody CreateTeacherDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<TeacherDTO> update(@RequestBody TeacherDTO dto, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen tanár", e);
        }
    }

    @PutMapping("/add/{courseId}")
    public ResponseEntity<TeacherDTO> addCourse(@RequestBody Long id, @PathVariable Long courseId) {
        return new ResponseEntity<>(service.addCourse(id , courseId), HttpStatus.CREATED);
    }
}
