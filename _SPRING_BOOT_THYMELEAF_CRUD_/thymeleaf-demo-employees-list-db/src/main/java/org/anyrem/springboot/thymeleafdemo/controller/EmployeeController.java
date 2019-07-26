package org.anyrem.springboot.thymeleafdemo.controller;

import org.anyrem.springboot.thymeleafdemo.service.EmployeeService;
import org.anyrem.springboot.thymeleafdemo.util.EmployeesFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees", employeeService.findAll());

        return "list-employees";
    }

}
