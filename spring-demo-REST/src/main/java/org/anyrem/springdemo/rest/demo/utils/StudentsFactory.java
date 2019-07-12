package org.anyrem.springdemo.rest.demo.utils;

import org.anyrem.springdemo.rest.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsFactory {

    private static List<Student> instance = getStudents();

    private static List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));

        return students;
    }

    public static List<Student> getInstance() {

        return instance;
    }

}
