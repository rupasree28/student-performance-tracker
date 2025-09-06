package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.dto.StudentPerformanceDTO;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }

    @GetMapping
    public List<Student> all() { return service.getAllStudents(); }

    @GetMapping("/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id) {
        return service.getStudentById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student s) {
        Student saved = service.createStudent(s);
        return ResponseEntity.created(URI.create("/api/students/" + saved.getId())).body(saved);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody Student s) {
        return ResponseEntity.ok(service.updateStudent(id, s));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // Performance
    @GetMapping("/top")
    public List<StudentPerformanceDTO> getTopStudents(@RequestParam(defaultValue = "5") int limit) {
        return service.topStudents(limit);
    }

    @GetMapping("/bottom")
    public List<StudentPerformanceDTO> getBottomStudents(@RequestParam(defaultValue = "5") int limit) {
        return service.bottomStudents(limit);
    }
    
    // Students with marks in a range
    @GetMapping("/range")
    public List<StudentPerformanceDTO> getStudentsInRange(@RequestParam double min,
                                                          @RequestParam double max) {
        return service.getStudentsInRange(min, max);
    }

    // Students with exact marks
    @GetMapping("/exact")
    public List<StudentPerformanceDTO> getStudentsByExactMarks(@RequestParam double value) {
        return service.getStudentsByExactMarks(value);
    }
    
    
    
}
