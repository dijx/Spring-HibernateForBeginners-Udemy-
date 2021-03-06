package org.anyrem.springboot.thymeleafdemo.controller;

import org.anyrem.springboot.thymeleafdemo.entity.Employee;
import org.anyrem.springboot.thymeleafdemo.service.EmployeeService;
import org.anyrem.springboot.thymeleafdemo.util.EmployeesFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model model) {

        model.addAttribute("employees", employeeService.findAllByOrderByLastNameAsc());

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

        model.addAttribute("employee", employeeService.findById(id));

        return "employees/employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {

        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }

}
