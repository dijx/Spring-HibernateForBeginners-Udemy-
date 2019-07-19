package org.anyrem.springboot.demo.demoapp1.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHallo() {
        return "Hello World!\nCurrent time is: " + LocalDateTime.now();
    }

    @GetMapping("/roll")
    public String giveWorkout() {
        return "Turlaj dropsa!";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName +
                "\nteam: " + teamName;
    }


}
