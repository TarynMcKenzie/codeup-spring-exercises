package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="posts") // a table of posts
public class Post { // a single post bean


    // --------------------------------------------
    // -------------------BEAN---------------------
    // --------------------------------------------

    // ---------- TABLE SETUP -----------

    // 1. Create a primary key for the post_db table of posts
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 2. A title that is required and has a character limit of 100.
    @Column(nullable = false, length = 100)
    private String title;

    // 3. A text body that is required and can be unlimited in characters.
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    // 4. Many Posts to one User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // ---------- CONSTRUCTOR METHOD(S) -----------
    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }


    // ---------- GET AND SET METHODS -----------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
