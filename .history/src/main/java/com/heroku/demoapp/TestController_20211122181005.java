package com.heroku.demoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class TestController {
    
    @GetMapping
    public String sayHello(){
        return "Hello Heroku";
    }
}
