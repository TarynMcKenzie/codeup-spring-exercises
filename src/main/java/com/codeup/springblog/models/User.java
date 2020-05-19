package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users") // a table of users
public class User { // a single user bean

    // --------------------------------------------
    // -------------------BEAN---------------------
    // --------------------------------------------

    // ---------- TABLE SETUP -----------

    // 1. Create a primary key for the post_db table of posts
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 2. A username that is unique and is required with a character limit of 100.
    @Column(nullable = false, unique = true, length = 100)
    private String username;

    // 2. An email that is required
    @Column(nullable = false)
    private String email;

    // 3. A password column
    @Column
    private String password;

    // 4. One user to Many posts
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> userPosts;


    // ---------- CONSTRUCTOR METHOD(S) -----------
    public User() {
    }

    // ----- COPY CONSTRUCTOR ----
    public User(User copy) { //  It is used as an alternative to cloning an object
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }
    //----------------------------

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, List<Post> userPosts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userPosts = userPosts;
    }

    public User(long id, String username, String email, String password, List<Post> userPosts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userPosts = userPosts;
    }


    // ---------- GET AND SET -----------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }
}
