package com.example.SpringAOPDemo.controller;


import com.example.SpringAOPDemo.service.StudentService;
import com.example.SpringAOPDemo.student.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    StudentService studentService;

    public  StudentController (StudentService s){
        this.studentService=s;
    }


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
          Student studentResponse=studentService.createStudent(student);

        return   ResponseEntity.ok( studentResponse);
    }

    @GetMapping
    public  ResponseEntity<String> dummyMethod(String s){
        String string="hello";
        String studentResponse=studentService.dummyMethod(string);

        return  ResponseEntity.ok(studentResponse);
    }

}
