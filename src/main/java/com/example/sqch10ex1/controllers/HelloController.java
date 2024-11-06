package com.example.sqch10ex1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {

    @GetMapping ("hello")
    //@ResponseBody
    public String hello(){
        return "Hello World";
    }

}
