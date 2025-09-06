package com.example.demo.dto;

public class StudentPerformanceDTO {
    private Long studentId;
    private String studentName;
    private Double averageScore;
    private Double minScore;
    private Double maxScore;

    public StudentPerformanceDTO(Long studentId, String studentName, Double averageScore, Double minScore, Double maxScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.averageScore = averageScore;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    // Getters
    public Long getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public Double getAverageScore() { return averageScore; }
    public Double getMinScore() { return minScore; }
    public Double getMaxScore() { return maxScore; }
}
