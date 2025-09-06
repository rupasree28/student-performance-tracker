package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "marks")  // ✅ Explicitly map to table marks
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private Double score;

    @ManyToOne
    @JoinColumn(name = "student_id")  // ✅ foreign key
    @JsonBackReference
    private Student student;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
