package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;



import static org.mockito.Mockito.doNothing;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.doThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentControllerTest {

    private final StudentService service = mock(StudentService.class);
    private final StudentController controller = new StudentController(service);

    // -------------------- Update Student Not Found --------------------
    @Test
    void testUpdateStudent_NotFound() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Charlie");

        // Simulate service returning null (student not found)
        when(service.updateStudent(eq(1L), any(Student.class))).thenReturn(null);

        ResponseEntity<?> response = controller.update(1L, student);

        assertEquals(404, response.getStatusCodeValue());
    }

    // -------------------- Update Student Found --------------------
    @Test
    void testUpdateStudent_Found() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Charlie");

        // Simulate service returning the updated student
        when(service.updateStudent(eq(1L), any(Student.class))).thenReturn(student);

        ResponseEntity<?> response = controller.update(1L, student);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(student, response.getBody());
    }

    // -------------------- Delete Student Found --------------------
    @Test
    void testDeleteStudent() {
        // Simulate successful deletion (void method)
        doNothing().when(service).deleteStudent(1L);

        ResponseEntity<?> response = controller.delete(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Student deleted successfully", response.getBody());
    }

    @Test
    void testDeleteStudent_NotFound() {
        // Simulate exception when student not found
        doThrow(new RuntimeException("Student not found")).when(service).deleteStudent(1L);

        ResponseEntity<?> response = controller.delete(1L);

        assertEquals(404, response.getStatusCodeValue());
        assertEquals("Student not found", response.getBody());
    }
}
