package com.in28minutes.unittesting.unittesting.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping("/hello-world")
public String helloWorld(){
    return "hello world";
}


}
