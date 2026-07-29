package com.example.SpringAOPDemo.service;


import com.example.SpringAOPDemo.student.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl  implements  StudentService{


    @Override
    public Student createStudent(Student student) {
        System.out.println("student created");

//        throw new RuntimeException(" error  happened");

        return student;
    }
}
