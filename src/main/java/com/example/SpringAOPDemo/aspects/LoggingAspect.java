package com.example.SpringAOPDemo.aspects;


import com.example.SpringAOPDemo.service.StudentService;
import com.example.SpringAOPDemo.student.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect   {

    StudentService studentService;

    public  LoggingAspect(StudentService s){
        this.studentService=s;
    }


//    //advice  //
//    @Before(" execution( String com.example.SpringAOPDemo.service.StudentService.createStudent())")
//   //advice
//    public void  loginBeforeCreate(JoinPoint joinPoint){
//          System.out.println("Before creating student");
//    }
//
//
//    @AfterReturning(" execution(String com.example.SpringAOPDemo.service.StudentService.createStudent())")
//    public void  loginAfterReturningCreate( ){
//         System.out.println("After Return ");
//    }
//
//    @AfterThrowing(" execution(String com.example.SpringAOPDemo.service.StudentService.createStudent())")
//    public void  loginAfterThrowingCreate(){
//
//         System.out.println("After throwing exception  ");
//    }
//
//    @After(" execution(String com.example.SpringAOPDemo.service.StudentService.createStudent())")
//    public void loginAfterCreate(){
//        System.out.println("after creating student");
//
//    }

//    @Around(" execution(*   com.example.SpringAOPDemo.service.StudentService.createStudent(..))")
//    public Student loginAroundCreate(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting : " + joinPoint.getSignature().getName());
//
//
//        try{
//           Student  student=(Student) joinPoint.proceed();
//            System.out.println("Execution successful");
//            return  student;
//        }
//        catch (Throwable e) {
//
//            System.out.println("Execution fail : " + e.getMessage());
//            throw e;
//        }
//        finally {
//            System.out.println("Execution completed");
//        }



    @Around(" execution(*   com.example.SpringAOPDemo.service.StudentService.dummyMethod(..))")
    public Object loginAroundCreate(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Starting : " + joinPoint.getSignature().getName());

        Object[] arr=joinPoint.getArgs();

        String originalString=(String) arr[0];

        String modifiefString=originalString.toUpperCase();

        Object[] modifiedArray={modifiefString};


        String returnType= (String) joinPoint.proceed(modifiedArray);

        returnType=returnType+" : "+ "String Intercepter";

        Object return1=joinPoint.proceed();

        System.out.println("Intercepted request calling again");

        Object return2=joinPoint.proceed();

        return return2;

    }

}
