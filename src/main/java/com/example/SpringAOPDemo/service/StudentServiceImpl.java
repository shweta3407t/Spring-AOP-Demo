package com.example.SpringAOPDemo.service;


import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl  implements  StudentService{
    @Override
    public String createStudent() {
        System.out.println("Student creating");
        return "Student created";
    }
}
