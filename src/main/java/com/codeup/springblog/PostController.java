package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts") // 1. GET
    @ResponseBody // 2 . Return HTML
    public String post(){
        return "Posts index page";
    }

    @GetMapping("/posts/{id}") // 1. GET
    @ResponseBody // 2 . Return HTML
    public String postId(@PathVariable int id){
        return "view an individual post: " + id;
    }

    @GetMapping("/posts/create") // 1. GET
    @ResponseBody // 2 . Return HTML
    public String postCreateForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create") // 1. POST
    @ResponseBody // 2 . Return HTML
    public String postCreate(){
        return "create a new post";
    }
}
