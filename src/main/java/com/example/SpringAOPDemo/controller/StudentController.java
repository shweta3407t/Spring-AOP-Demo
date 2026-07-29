package com.example.SpringAOPDemo.controller;


import com.example.SpringAOPDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {

    StudentService studentService;

    public  StudentController (StudentService s){
        this.studentService=s;
    }


    @PostMapping
    public ResponseEntity<String> createStudent(){
          String student=studentService.createStudent();

        return   ResponseEntity.ok( student);
    }

}
