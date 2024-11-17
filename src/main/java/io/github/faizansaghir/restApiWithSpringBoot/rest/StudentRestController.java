package io.github.faizansaghir.restApiWithSpringBoot.rest;

import io.github.faizansaghir.restApiWithSpringBoot.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return students.get(studentId);
    }

}
