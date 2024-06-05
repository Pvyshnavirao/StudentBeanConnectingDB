package com.example.Student.Service;


import com.example.Student.Repository.StudentRepo;
import com.example.Student.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;



    public void addStudent(Student s) {
        repo.save(s);
    }

    public List<Student> getStudents() {
        return  repo.findAll();
    }
}
