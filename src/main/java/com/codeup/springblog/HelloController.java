package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 1. Dictates that this class is the controller (MVC)
public class HelloController {

    @GetMapping("/hello") // 2. GET request at /
    @ResponseBody // 3. Return HTML
    public String hello(){
        return "This is the landing page!";
    }


    @GetMapping("/helloSpring") // 2. GET request at /hello
    @ResponseBody // 3. Return HTML
    public String helloSpring(){
        return "Hello, from Spring!";
    }
}
