package com.webler.school.entity.grades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("SELECT new com.webler.school.entity.grades.AvgDTO(s.name, AVG(g.grade)) FROM Grade g INNER JOIN g.student s GROUP BY s.name ORDER BY AVG(g.grade) ASC")
    List<AvgDTO> listStudentByGradeAvg();
}
