package org.anyrem.springemo.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

//        return "plain-login";
        return "fancy-login";
    }

    @RequestMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}
