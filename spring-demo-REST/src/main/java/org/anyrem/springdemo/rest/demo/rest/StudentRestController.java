package org.anyrem.springdemo.rest.demo.rest;

import org.anyrem.springdemo.rest.demo.entity.Student;
import org.anyrem.springdemo.rest.demo.exception_handling.StudentErrorResponse;
import org.anyrem.springdemo.rest.demo.exception_handling.StudentNotFoundException;
import org.anyrem.springdemo.rest.demo.utils.StudentsFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


//    @PostConstruct
//    private void loadData() {
//        private students = StudentsFactory.getInstance();
//    }


    @GetMapping("/students")
    public List<Student> getStudents() {

        return StudentsFactory.getInstance();
    }


    @PostMapping("/students")
    public List<Student> getStudentParmeter(@RequestParam("id") int[] studentId) {

        List<Student> tempList = new ArrayList<>();

        for (int i : studentId) {

            if (i < StudentsFactory.getInstance().size() && i >= 0) {
                tempList.add(StudentsFactory.getInstance().get(i));
            } else {
                tempList.add(new Student("NO_SUCH_ID: " + i, "NO_DATA"));
            }
        }

        return tempList;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId < StudentsFactory.getInstance().size() && studentId >= 0) {
            return StudentsFactory.getInstance().get(studentId);
        } else {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
    }

/*
// if placed here, below is controller specific, not reusable

    private StudentErrorResponse studentErrorResponse(Exception ex, HttpStatus httpStatus)
    {
        StudentErrorResponse err = new StudentErrorResponse(
                httpStatus.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );

        return err;
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {

        return new ResponseEntity<>(studentErrorResponse(ex,HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity <StudentErrorResponse> handleException(Exception ex) {

        return new ResponseEntity<>(studentErrorResponse(ex, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);

    }

*/

}
