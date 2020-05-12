package com.codeup.springblog;

public class Post {
    // --------------------------------------------
    // -------------------BEAN---------------------
    // --------------------------------------------

    // ---------- INITIALIZE -----------
    private String title;
    private String body;
    private int id;


    // ---------- CONSTRUCTOR METHOD(S) -----------
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(int id, String title, String body) {
        this.title = title;
        this.body = body;
    }


    // ---------- GET AND SET METHODS -----------
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
