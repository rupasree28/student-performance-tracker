package com.example.demo.service;

import com.example.demo.dto.StudentPerformanceDTO;
import com.example.demo.model.Marks;
import com.example.demo.model.Student;
import com.example.demo.repository.MarksRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final MarksRepository marksRepo;

    public StudentService(StudentRepository studentRepo, MarksRepository marksRepo) {
        this.studentRepo = studentRepo;
        this.marksRepo = marksRepo;
    }

    // --- Student CRUD ---
    public List<Student> getAllStudents() { return studentRepo.findAll(); }

    public Optional<Student> getStudentById(Long id) { return studentRepo.findById(id); }

    public Student createStudent(Student s) {
        if (s.getMarks() != null) {
            List<Marks> copy = new ArrayList<>(s.getMarks());
            s.getMarks().clear();
            for (Marks m : copy) s.addMark(m);   // ✅ set parent
        }
        return studentRepo.save(s);
    }

    public Student updateStudent(Long id, Student s) {
        Student existing = studentRepo.findById(id).orElseThrow();
        existing.setName(s.getName());

        if (s.getMarks() != null) {
            existing.clearAndSetMarks(s.getMarks()); // ✅ keep both sides
        }
        return studentRepo.save(existing);
    }

    public void deleteStudent(Long id) { studentRepo.deleteById(id); }

    // --- Marks ---
    public Marks addMarkToStudent(Long studentId, Marks mark) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        student.addMark(mark);        // ✅ sets student_id
        studentRepo.save(student);    // cascade saves mark
        return mark;
    }

    public List<Marks> getMarksForStudent(Long studentId) {
        return marksRepo.findByStudentId(studentId);
    }

    // --- Performance ---
    public List<StudentPerformanceDTO> topStudents(int limit) {
        List<StudentPerformanceDTO> all = marksRepo.findTopPerformers();
        return all.subList(0, Math.min(limit, all.size()));
    }

    public List<StudentPerformanceDTO> bottomStudents(int limit) {
        List<StudentPerformanceDTO> all = marksRepo.findBottomPerformers();
        return all.subList(0, Math.min(limit, all.size()));
    }
    
    public List<StudentPerformanceDTO> getStudentsInRange(double min, double max) {
        return marksRepo.findStudentsInRange(min, max);
    }

    public List<StudentPerformanceDTO> getStudentsByExactMarks(double value) {
        return marksRepo.findStudentsByExactMarks(value);
    }

    
}
