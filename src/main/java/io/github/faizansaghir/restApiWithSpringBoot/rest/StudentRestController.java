package io.github.faizansaghir.restApiWithSpringBoot.rest;

import io.github.faizansaghir.restApiWithSpringBoot.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Faizan", "Saghir"));
        students.add(new Student("Adil", "Rashid"));
        students.add(new Student("Nazir", "Samer"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        if(studentId>=students.size() || studentId<0)
            throw new StudentNotFoundException("Student id not found - "+studentId);
        return students.get(studentId);
    }

}
