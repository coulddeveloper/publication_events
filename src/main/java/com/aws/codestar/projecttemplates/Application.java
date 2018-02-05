package com.aws.codestar.projecttemplates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Simple class to start up the application.
 *
 * @SpringBootApplication adds:
 *  @Configuration
 *  @EnableAutoConfiguration
 *  @ComponentScan
 */
@SpringBootApplication
@Configuration
@ComponentScan("com.aws.codestar.projecttemplate")
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
    
        SpringApplication.run(Application.class, args );
    }
}
