package org.anyrem.springemo.mvc.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        super.configure(auth);

        //in memory autentication (deprecated since Spring MVC 5.0.2)
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("test123").roles("MANAGER", "EMPLOYEE"))
                .withUser(users.username("susan").password("test123").roles("ADMIN", "EMPLOYEE"))
                .withUser(users.username("remik").password("test123").roles("MANAGER", "ADMIN", "EMPLOYEE"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        super.configure(http);
        http.authorizeRequests()
//                .anyRequest()
                .antMatchers("/").permitAll()
                .antMatchers("/employees/**").authenticated()
                .antMatchers("/managers/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .antMatchers("/logout").permitAll()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
        ;

    }
}
