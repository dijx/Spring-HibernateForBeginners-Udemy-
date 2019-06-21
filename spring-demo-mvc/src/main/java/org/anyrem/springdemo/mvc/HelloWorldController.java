package org.anyrem.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/hello")
public class HelloWorldController {

    @RequestMapping(value = "/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm() {
        return "helloWorld";
    }

    @RequestMapping(value = "/processFormV2")
    public String letsShout(HttpServletRequest request, Model model) {

        String theName = request.getParameter("studentName2").toUpperCase();
        String message = "Here's your message, " + theName;
        model.addAttribute("message", message);

        return "helloWorld";
    }

    @RequestMapping(value = "/processFormV3")
    public String processFormV3(@RequestParam("studentName3") String theName, Model model) {

        theName = theName.toUpperCase();
        String message = "Hello from V3, " + theName;
        model.addAttribute("message", message);

        return "helloWorld";
    }
}
