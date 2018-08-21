package com.example.moonmayor.photodownloader;

public class InstagramPost {
    public String author;
    public String imageUrl;
    public String description;

    public InstagramPost(String author, String description, String url) {
        this.author = author;
        this.description = description;
        this.imageUrl = url;
    }
}
