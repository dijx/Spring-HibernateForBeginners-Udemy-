package org.anyrem.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Value("#{operatingSystem}")
    private Map<String, String> operatingSystem;


    @RequestMapping(value = "/showForm")
    public String showForm(Model theModel) {

        theModel.addAttribute("student", new Student());
        theModel.addAttribute("OS", operatingSystem);
        return "student-form";
    }

    @RequestMapping(value = "/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.println("Student: " + theStudent.getFirstName() + "  " + theStudent.getLastName());
        return "student-confirmation";
    }

}
