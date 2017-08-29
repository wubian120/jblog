package com.brianwu.jblog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.brianwu.jblog")
@ServletComponentScan
public class Application {

    public static void main(String[] args){
        System.out.println("... jblog project ...");
        SpringApplication.run(Application.class, args);

    }

}
