package com.appv1.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class DemoAppApplication {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoAppApplication.class, args);
    }

}
