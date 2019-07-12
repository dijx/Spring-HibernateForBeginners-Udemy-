package org.anyrem.springdemo.rest.demo.rest;

import org.anyrem.springdemo.rest.demo.entity.Student;
import org.anyrem.springdemo.rest.demo.utils.StudentsFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {

        StudentsFactory studentsFactory = new StudentsFactory();

        return studentsFactory.getStudents();
    }

}
