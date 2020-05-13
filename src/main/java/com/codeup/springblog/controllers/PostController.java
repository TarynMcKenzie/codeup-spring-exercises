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

    // --------- INTIALIZE ------------
    private PostRepository postRepo;

    // --------- CONSTRUCTOR METHOD ------------
    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    // --------- ALL POSTS VIEW ------------
    @GetMapping("/posts") // 1. GET
    public String getPosts(Model model) {

        ArrayList<Post> postList = new ArrayList<>(); // New instance of an ArrayList

        Post likes = new Post(1, "What I like", "I like to sleep allllll day. Thanks for reading!"); // create new post object with dummy data
        postList.add(likes); // add dummy data to the ArrayList

        Post dislikes = new Post(1, "What I do not like", "I do not like to wake up early. Thanks for reading!"); // create new post object with dummy data
        postList.add(dislikes); // add dummy data to the ArrayList

        model.addAttribute("postList", postList);// Pass the ArrayList to the html



        String html = "<div class='post-card'>";
        for (Post post: this.postRepo.findAll()){
            html +=  "<h2>" + post.getTitle() + "</h2><p>" + post.getBody() + "</p></div>";
        }


        return "/posts/index";
    }

    // --------- INDIVIDUAL POST VIEW ------------
    @GetMapping("/posts/{id}") // 1. GET
    public String getPostById(@PathVariable int id, Model model) {
        model.addAttribute("currentPost", id);

        Post newPost = new Post("newTitle", "The Description"); // Create a new post object
        model.addAttribute("newPost", newPost); // Pass the post object to the HTML

        return "/posts/show";
    }


    // --------- CREATE ------------
    @GetMapping("/posts/create") // 1. GET
    public String postCreateForm( Model model ) {
        return "/posts/create";
    }

    @PostMapping("/posts/create") // 1. POST
    public String createNewPost( @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {

        Post post = new Post(); // create a new post instance
        post.setTitle(title); // set the new post's title
        post.setBody(body); // set the new post's body

        this.postRepo.save(post); // Save the new post
        return "/posts/create";
    }


    // --------- EDIT------------
    @GetMapping("/posts/{id}/edit") // 1. GET
    public String postEditForm(@PathVariable int id, Model model) {
        return "/posts/{id}/edit";
    }

    @PostMapping("/posts/{id}/edit") // 1. POST
    public String postEdit(@PathVariable int id, Model model) {
        return "/posts/{id}/edit";
    }


    // --------- DELETE ------------
    @GetMapping("/posts/{id}/delete") // 1. GET
    public String postDeleteForm(@PathVariable int id, Model model) {
        return "/posts/{id}/delete";
    }

    @PostMapping("/posts/{id}/delete") // 1. POST
    public String postDelete(@PathVariable int id, Model model) {
        return "/posts/{id}/delete";
    }
}
