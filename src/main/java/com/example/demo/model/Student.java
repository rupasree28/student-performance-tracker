package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "students")   // ✅ Explicitly map to table students
public class Student {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Marks> marks = new ArrayList<>();

    // --- helper methods to maintain both sides ---
    public void addMark(Marks m) {
        marks.add(m);
        m.setStudent(this);   // ✅ ensures student_id is never null
    }

    public void clearAndSetMarks(List<Marks> newMarks) {
        for (Marks m : this.marks) m.setStudent(null);
        this.marks.clear();
        if (newMarks != null) {
            for (Marks m : newMarks) addMark(m);
        }
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Marks> getMarks() { return marks; }
    public void setMarks(List<Marks> marks) { this.marks = marks; }
}
