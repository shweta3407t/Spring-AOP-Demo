package com.example.SpringAOPDemo.service;


import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl  implements  StudentService{
    @Override
    public String createStudent() {
        System.out.println("Student created");

        throw  new RuntimeException("exception accured");

//        return "Student created";
    }
}
