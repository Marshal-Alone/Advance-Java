package edu.learningspringboot.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
public class root {
    @GetMapping("")
    public String hello(){
        return "<h1>Welcome !!!!</h1>";
    }

    //localhost:8080/name/any_name
    @GetMapping("/hi/{name}")
    public String hi(@PathVariable String name){
        return "Hello ----> "+ name;
    }

    @PostMapping("/post")
    public String post(){
        return "<i>This is a post request</i>";
    }
}
