package com.main;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.main.models.Student;
import com.main.services.StudentService; 
@WebMvcTest
class StudentControllerTest {
    
    @Autowired
    private MockMvc mvc;
 
    @MockitoBean
    private StudentService service;
 
    private Student student;
    
    @BeforeEach
    void setUp() {
        student = new Student(1, "Dummy", 10, "DPS", 75.00);
    }
 
    private List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(student);
        return students;
    }
 
    @Test
    void testFetchAllStudent() throws Exception {
        when(service.getAllStudents()).thenReturn(getStudents());
        
        mvc.perform(get("/students"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Dummy"))
           .andExpect(jsonPath("$[0].percentage").value(75.00));
    }
 
    @Test
    void testGetStudent() throws Exception {
        when(service.getStudentOnRollNo(1)).thenReturn(student);
 
        mvc.perform(get("/student/{rollNo}", 1).param("school", "DPS"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.name").value("Dummy"))
           .andExpect(jsonPath("$.percentage").value(75.00));
    }
 
    @Test
    void testGetStudentBySchool() throws Exception {
        when(service.getStudentOnSchoolName("DPS")).thenReturn(getStudents());
 
        mvc.perform(get("/student/school").param("name", "DPS"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].school").value("DPS"));
    }
 
    @Test
    void testGetResult() throws Exception {
        when(service.getStudentOnResult(true)).thenReturn(getStudents());
 
        mvc.perform(get("/students/result").param("pass", "true"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Dummy"));
    }
 
    @Test
    void testGetStudentByStandard() throws Exception {
        when(service.getStudentCountOnStd(12)).thenReturn(1l);
 
        mvc.perform(get("/students/{standard}/count", 12))
           .andExpect(status().isOk())
           .andExpect(content().string("1"));
    }
 
    @Test
    void testGetStrengthBySchool() throws Exception {
        when(service.getStudentCountOnSchool("DPS")).thenReturn(50l);
 
        mvc.perform(get("/students/strength").param("school", "DPS"))
           .andExpect(status().isOk())
           .andExpect(content().string("50"));
    }
 
    @Test
    void testGetToppers() throws Exception {
        when(service.getTopFiveStudents()).thenReturn(getStudents());
 
        mvc.perform(get("/students/toppers"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Dummy"))
           .andExpect(jsonPath("$[0].percentage").value(75.00));
    }
 
    @Test
    void testGetTopperByStandard() throws Exception {
        when(service.getTopperOnStd(12)).thenReturn((Student) getStudents());
 
        mvc.perform(get("/students/topper/{standard}", 12).param("school", "DPS"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Dummy"));
    }
 
    @Test
    void testAddStudent() throws Exception {
        when(service.addStudent(student)).thenReturn(student);
 
        mvc.perform(post("/student/add")
                .param("name", "Dummy")
                .param("school", "DPS")
                .param("standard", "12")
                .param("percentage", "75.00"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.name").value("Dummy"))
           .andExpect(jsonPath("$.percentage").value(75.00));
 
        verify(service).addStudent(student); // Verify service method was called
    }
}