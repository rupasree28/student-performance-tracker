package com.example.demo.controller;

import com.example.demo.model.Marks;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    private final StudentService service;

    public MarksController(StudentService service) {
        this.service = service;
    }

    // ✅ Get all marks of a student
    @GetMapping("/{studentId}")
    public List<Marks> getMarksForStudent(@PathVariable Long studentId) {
        return service.getMarksForStudent(studentId);
    }

    // ✅ Add mark to student
    @PostMapping("/{studentId}")
    public Marks addMark(@PathVariable Long studentId, @RequestBody Marks mark) {
        return service.addMarkToStudent(studentId, mark);
    }
}
