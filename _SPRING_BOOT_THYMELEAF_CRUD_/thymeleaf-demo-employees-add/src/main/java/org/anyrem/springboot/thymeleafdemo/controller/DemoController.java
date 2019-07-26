package org.anyrem.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("theDate", LocalDateTime.now());

        return "helloworld";
    }

    @GetMapping("/")
    public String rootRedirect() {

        return "redirect:employees/list";
    }

}
