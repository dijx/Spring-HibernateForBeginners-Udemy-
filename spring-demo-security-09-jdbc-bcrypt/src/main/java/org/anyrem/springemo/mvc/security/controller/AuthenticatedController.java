package org.anyrem.springemo.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticatedController {

    @GetMapping("/employees")
    public String showEmployeesPage() {

        return "employees";
    }

    @GetMapping("/systems")
    public String showAdminsPage() {

        return "systems";
    }

    @GetMapping("/managers")
    public String showManagersPage() {

        return "managers";
    }
}
