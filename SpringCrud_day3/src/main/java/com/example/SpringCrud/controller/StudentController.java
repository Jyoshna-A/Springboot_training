package com.example.SpringCrud.controller;

import com.example.SpringCrud.model.Student;
import com.example.SpringCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService service;
    @GetMapping("Student")

    public List<Student> getStudents()
    {
        return service.getStudents();
    }

    @GetMapping("Studentid/{rolln}")
    public Student getid(@PathVariable("rolln")int rolln)
    {
        return service.getStudentId(rolln);
    }
    @PostMapping("Student")
    public String addStudent(@RequestBody Student student)
    {
        service.addStudents(student);
        return "success";
    }

    @PutMapping("Student")
    public String updateStudent(@RequestBody Student student)
    {
        service.updateStudents(student);
        return "update success";
    }
}
