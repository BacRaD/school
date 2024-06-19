package com.webler.school.app;

import com.webler.school.entity.grades.AvgDTO;
import com.webler.school.entity.grades.GradeDTO;
import com.webler.school.entity.person.student.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@RestController
@RequestMapping("api")

public class AppController {

    @Autowired
    private AppService service;

    @GetMapping("/8")
    public Double feladat_8() {
        return service.allSum();
    }

    @GetMapping("/9/{string}")
    public List<StudentDTO> feladat_9(@PathVariable String string) {
        return service.filteredStudents(string);
    }

    @GetMapping("/10")
    public Map<String, Double> feladat_10() {
        return service.getAvgByMonth();
    }

    @GetMapping("/11")
    public Queue<AvgDTO> feladat_11() {
        return service.studentQueue();
    }
}
