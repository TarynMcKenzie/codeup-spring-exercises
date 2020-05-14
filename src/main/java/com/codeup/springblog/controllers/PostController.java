package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    // --------- INITIALIZE ------------
    private PostRepository postRepo;

    // --------- CONSTRUCTOR METHOD ------------
    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    // --------- ALL POSTS VIEW ------------
    @GetMapping("/posts") // 1. GET
    public String getPosts(Model model) {

        model.addAttribute("posts", postRepo.findAll()); // Place all the ads on the page

        return "/posts/index";
    }

    // --------- INDIVIDUAL POST VIEW ------------
    @GetMapping("/posts/{id}") // 1. GET
    public String getPostById(@PathVariable long id, Model model) {

        model.addAttribute("currentPost", postRepo.getOne(id)); // find the ad by its id

        return "/posts/show";
    }


    // --------- CREATE ------------
    @GetMapping("/posts/create") // 1. GET
    public String postCreateForm( Model model ) {

        model.addAttribute("post", new Post());

        return "/posts/create";
    }

    @PostMapping("/posts/create") // 1. POST
    public String createNewPost( @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {

        Post post = new Post(title, body); // create a new post instance with title and body param

        postRepo.save(post); // Save the new post

        return "redirect:/posts";
    }


    // --------- EDIT------------
    @GetMapping("/posts/{id}/edit") // 1. GET
    public String postEditForm(@PathVariable long id, Model model) {

        Post post = postRepo.getPostById(id);
        model.addAttribute("post", post);

        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit") // 1. POST
    public String postEdit(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {

        Post post = postRepo.getPostById(id); // get the id of the post
        post.setTitle(title);
        post.setBody(body);

        postRepo.save(post); // Edit the new post

        return "redirect:/posts";
    }


    // --------- DELETE ------------
    @GetMapping("/posts/{id}/delete") // 1. GET
    public String postDeleteForm(@PathVariable long id, Model model) {
        return "/posts/delete";
    }

    @PostMapping("/posts/{id}/delete") // 1. POST
    public String postDelete(@PathVariable long id) {

        postRepo.deleteById(id); // Delete the new post

        return "redirect:/posts";
    }
}
