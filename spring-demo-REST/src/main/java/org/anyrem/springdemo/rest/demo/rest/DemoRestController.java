package org.anyrem.springdemo.rest.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@RestController
@RequestMapping("test")
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHallo() {

        return "Hello World!";
    }


}
