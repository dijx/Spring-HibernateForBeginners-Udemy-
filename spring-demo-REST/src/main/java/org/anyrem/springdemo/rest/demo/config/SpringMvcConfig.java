package org.anyrem.springdemo.rest.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvc
@ComponentScan("org.anyrem.springdemo.rest.demo")
public class SpringMvcConfig {

}
