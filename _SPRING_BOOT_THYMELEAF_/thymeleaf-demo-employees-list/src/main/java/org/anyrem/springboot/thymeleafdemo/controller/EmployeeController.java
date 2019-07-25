package org.anyrem.springboot.thymeleafdemo.controller;

import org.anyrem.springboot.thymeleafdemo.util.EmployeesFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    @GetMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees", EmployeesFactory.getInstance());

        return "list-employees";
    }

}
