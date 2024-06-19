package com.webler.school.entity.grades;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("grade")

public class GradeController {

    @Autowired
    private GradeService service;

    @GetMapping
    public ResponseEntity<List<GradeDTO>> list() {
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeDTO> get(@PathVariable Long id) {
        return new  ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping("/{studentId}/{courseId}")
    public ResponseEntity<GradeDTO> create(@Valid @RequestBody CreateGradeDTO dto, @PathVariable Long studentId, @PathVariable Long courseId) {
        return new ResponseEntity<>(service.create(dto, studentId, courseId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<GradeDTO> update(@Valid @RequestBody GradeDTO dto, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(dto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return HttpStatus.OK;
        } catch (Exception  e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen jegy");
        }

    }
}
