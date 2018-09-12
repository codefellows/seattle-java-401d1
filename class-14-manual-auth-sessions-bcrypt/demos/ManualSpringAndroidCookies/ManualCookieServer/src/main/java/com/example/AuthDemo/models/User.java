package com.example.AuthDemo.models;

import com.example.AuthDemo.pojos.UserPojo;
import org.mindrot.jbcrypt.BCrypt;

public class User {
    private static final String DEFAULT_NAME = "No Name";
    private static final String DEFAULT_PASS = "password";

    public int id;
    public String username;
    public String bio;
    private String passhash;

    public User() {
        this(DEFAULT_NAME, DEFAULT_PASS);
    }

    public User(String username, String password) {
        this(username, password, "");
    }

    public User(UserPojo user) {
        this(user.username, user.password, user.bio);
    }

    public User(String username, String password, String bio) {
        this(-1, username, password, bio);
    }

    public User(int id, String username, String password, String bio) {
        this.id = id;
        this.username = username;
        this.passhash = password;
        this.bio = bio;
    }

    public boolean checkPassword(String attempt) {
        boolean result = BCrypt.checkpw(attempt, this.passhash);
        return result;
    }
}
