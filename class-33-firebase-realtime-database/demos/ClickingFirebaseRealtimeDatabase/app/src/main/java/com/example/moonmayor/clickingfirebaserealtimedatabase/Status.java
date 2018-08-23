package com.example.moonmayor.clickingfirebaserealtimedatabase;

public class Status {
    public String username;
    public String status;      // one of "online", "away", "offline"
    public String statusText;  // "I'm grabbing a sandwhich"

    public Status(String username, String status, String statusText) {
        this.username = username;
        this.status = status;
        this.statusText = statusText;
    }
}
