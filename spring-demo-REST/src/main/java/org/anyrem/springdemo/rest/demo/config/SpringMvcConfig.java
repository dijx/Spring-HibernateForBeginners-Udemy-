package org.anyrem.springdemo.rest.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("org.anyrem.springdemo.rest.demo")
public class SpringMvcConfig {
}
