package com.example.SpringCrud.service;

import com.example.SpringCrud.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> a=new ArrayList<>(Arrays.asList(new Student(1,22,"Jyos"),new Student(2,52,"ram")));

    public List<Student> getStudents() {
        return a;
    }

    public Student getStudentId(int rolln) {
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getRoll()==rolln)
            {
                return a.get(i);
            }
        }
        return null;
    }

    public void addStudents(Student student) {
           a.add(student);
    }

    public void updateStudents(Student student) {
        
    }
}
