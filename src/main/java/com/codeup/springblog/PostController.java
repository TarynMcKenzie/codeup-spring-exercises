package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    // --------- ALL POSTS VIEW ------------
    @GetMapping("/posts") // 1. GET
    public String post(Model model) {

        ArrayList<Post> postList = new ArrayList<>(); // New instance of an ArrayList
        model.addAttribute("postList", postList);// Pass the ArrayList to the html

        Post likes = new Post(1, "What I like", "I like to sleep allllll day. Thanks for reading!"); // create new post object with dummy data
        postList.add(likes); // add dummy data to the ArrayList

        Post dislikes = new Post(1, "What I do not like", "I do not like to wake up early. Thanks for reading!"); // create new post object with dummy data
        postList.add(dislikes); // add dummy data to the ArrayList


        return "/posts/index";
    }

    // --------- INDIVIDUAL POST VIEW ------------
    @GetMapping("/posts/{id}") // 1. GET
    public String postId(@PathVariable int id, Model model) {
        model.addAttribute("currentPost", id);

        Post newPost = new Post("newTitle", "The Description"); // Create a new post object
        model.addAttribute("newPost", newPost); // Pass the post object to the HTML

        return "/posts/show";
    }


    // --------- CREATE ------------
    @GetMapping("/posts/create") // 1. GET
    @ResponseBody // 2 . Return HTML
    public String postCreateForm( Model model ) {
        return "/posts/{id}/delete";
    }

    @PostMapping("/posts/create") // 1. POST
    @ResponseBody // 2 . Return HTML
    public String postCreate( Model model ) {
        return "/posts/{id}/delete";
    }


    // --------- EDIT------------
    @GetMapping("/posts/{id}/edit") // 1. GET
    @ResponseBody // 2 . Return HTML
    public String postEditForm(@PathVariable int id, Model model) {
        return "/posts/{id}/delete";
    }

    @PostMapping("/posts/{id}/edit") // 1. POST
    @ResponseBody // 2 . Return HTML
    public String postEdit(@PathVariable int id, Model model) {
        return "/posts/{id}/delete";
    }


    // --------- DELETE ------------
    @GetMapping("/posts/{id}/delete") // 1. GET
    @ResponseBody // 2 . Return HTML
    public String postDeleteForm(@PathVariable int id, Model model) {
        return "/posts/{id}/delete";
    }

    @PostMapping("/posts/{id}/delete") // 1. POST
    @ResponseBody // 2 . Return HTML
    public String postDelete(@PathVariable int id, Model model) {
        return "delete a new post";
    }
}
