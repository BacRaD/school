package com.webler.school.app;

import com.webler.school.entity.grades.AvgDTO;
import com.webler.school.entity.grades.GradeDTO;
import com.webler.school.entity.grades.GradeService;
import com.webler.school.entity.person.student.StudentDTO;
import com.webler.school.entity.person.student.StudentService;
import com.webler.school.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AppService {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    public Double allSum() {
        Double result = 0.00;
        List<Integer> list = gradeService.list().stream().map(GradeDTO::getGrade).toList();
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        result = result/list.size();

        return result;
    }

    public List<StudentDTO> filteredStudents(String str) {
        List<StudentDTO> students = studentService.list();
        List<StudentDTO> respose = new ArrayList<>();

        for (var x : students) {
            Pattern pattern = Pattern.compile(str, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(x.getName());
            boolean matched = matcher.find();

            if(matched) {
                respose.add(x);
            }
        }

        return respose;
    }

    public Map<String, Double> getAvgByMonth() {
        Map<String, Double> map = new HashMap<>();
        List<GradeDTO> grades = gradeService.list();

        for (var x : grades) {
            String str = Utils.keyFromDate(x.getDate());
            if(map.containsKey(str)) {
                Double db = (map.get(str) + x.getGrade()) / 2;
                map.put(str, Utils.round(db));
            } else {
                map.put(str, (double)x.getGrade());
            }
        }

        return map;
    }

    public Queue<AvgDTO> studentQueue() {
        Queue<AvgDTO> pq = new PriorityQueue<>(gradeService.listStudentByGradeAvg());
        return pq;
    }
}
