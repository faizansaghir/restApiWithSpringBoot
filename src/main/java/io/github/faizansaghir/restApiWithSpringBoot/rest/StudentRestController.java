package io.github.faizansaghir.restApiWithSpringBoot.rest;

import io.github.faizansaghir.restApiWithSpringBoot.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Faizan", "Saghir"));
        students.add(new Student("Adil", "Rashid"));
        students.add(new Student("Nazir", "Samer"));
        return students;
    }

}
