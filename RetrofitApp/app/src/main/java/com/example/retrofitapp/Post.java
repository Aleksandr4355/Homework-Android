package com.example.retrofitapp;

public class Post {
    private String userId,title,body, id;

    public Post(String userId, String title, String body, String id) {
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Post(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getId() {
        return id;
    }
}
