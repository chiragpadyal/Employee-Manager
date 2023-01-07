package com.chiragpadyal.springboottutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String helloworld(){
        return "Welcome to home is a joke!";
    }
}
