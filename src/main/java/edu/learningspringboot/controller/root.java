package edu.learningspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class root {
    @GetMapping("")
    public String root(){
        return "<h1>Welcome !!!!</h1>";
    }
}
