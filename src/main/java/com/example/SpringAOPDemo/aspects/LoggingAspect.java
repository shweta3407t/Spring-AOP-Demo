package com.example.SpringAOPDemo.aspects;


import com.example.SpringAOPDemo.service.StudentService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect   {

    StudentService studentService;

    public  LoggingAspect(StudentService s){
        this.studentService=s;
    }


    //advice  //
    @Before(" execution( String com.example.SpringAOPDemo.service.StudentService.createStudent())")
   //advice
    public void  loginBeforeCreate(JoinPoint joinPoint){
          System.out.println("Before creating student");
    }


    @AfterReturning(" execution(String com.example.SpringAOPDemo.service.StudentService.createStudent())")
    public void  loginAfterReturningCreate(JoinPoint joinPoint){

        Object[] arr=joinPoint.getArgs();
         System.out.println("After creating student");
    }

}
