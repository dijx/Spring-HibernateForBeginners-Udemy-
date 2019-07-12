package org.anyrem.springdemo.rest.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootRedirector {

    @RequestMapping("/")
    public String redirect() {
        //return "redirect: test/hello";
        return "redirect: api/students";
    }
}
