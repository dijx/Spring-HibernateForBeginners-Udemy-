package org.anyrem.springdemo.rest.demo.utils;

import org.anyrem.springdemo.rest.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsFactory {

    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));

        return students;
    }


}
