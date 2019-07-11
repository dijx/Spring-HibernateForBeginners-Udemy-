package org.anyrem.springemo.mvc.security.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.anyrem.springemo.mvc.security")
@PropertySource("classpath:persistence-mysql.properties")
public class SpringMvcConfig {

    //holds information from property file (@PropertySource)
    @Autowired
    private Environment env;

    private static final Logger logger = Logger.getLogger(org.anyrem.springemo.mvc.security.config.SpringMvcConfig.class.getName());


    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }


    @Bean
    public DataSource securityDataSource() {

        //create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();


        //set the jdbc driver class
        try {

            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));

        } catch (PropertyVetoException e) {

            throw new RuntimeException(e);
        }

        logger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user = " + env.getProperty("jdbc.user"));


        //set database connection properties
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));


        //set connection pool properties
        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize", 3));

        securityDataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize", 3));

        securityDataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize", 10));

        securityDataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime", 5000));


        return securityDataSource;
    }


    private int getIntProperty(String propertyName, int defaultValue) {

        propertyName = env.getProperty(propertyName);

        return org.apache.commons.lang3.math.NumberUtils.toInt(propertyName, defaultValue);
    }


}
