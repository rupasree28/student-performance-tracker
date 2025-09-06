package com.example.demo.repository;

import com.example.demo.dto.StudentPerformanceDTO;
import com.example.demo.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Long> {

    @Query("SELECT new com.example.demo.dto.StudentPerformanceDTO(" +
            "m.student.id, m.student.name, AVG(m.score), MIN(m.score), MAX(m.score)) " +
            "FROM Marks m GROUP BY m.student.id, m.student.name ORDER BY AVG(m.score) DESC")
    List<StudentPerformanceDTO> findTopPerformers();

    @Query("SELECT new com.example.demo.dto.StudentPerformanceDTO(" +
            "m.student.id, m.student.name, AVG(m.score), MIN(m.score), MAX(m.score)) " +
            "FROM Marks m GROUP BY m.student.id, m.student.name ORDER BY AVG(m.score) ASC")
    List<StudentPerformanceDTO> findBottomPerformers();

    List<Marks> findByStudentId(Long studentId);
    
    
    // Students whose average score is between min and max
    @Query("SELECT new com.example.demo.dto.StudentPerformanceDTO(" +
            "m.student.id, m.student.name, AVG(m.score), MIN(m.score), MAX(m.score)) " +
            "FROM Marks m GROUP BY m.student.id, m.student.name " +
            "HAVING AVG(m.score) BETWEEN :min AND :max " +
            "ORDER BY AVG(m.score) DESC")
    List<StudentPerformanceDTO> findStudentsInRange(double min, double max);

    // Students whose average score equals a value
    @Query("SELECT new com.example.demo.dto.StudentPerformanceDTO(" +
            "m.student.id, m.student.name, AVG(m.score), MIN(m.score), MAX(m.score)) " +
            "FROM Marks m GROUP BY m.student.id, m.student.name " +
            "HAVING AVG(m.score) = :value")
    List<StudentPerformanceDTO> findStudentsByExactMarks(double value);

}
