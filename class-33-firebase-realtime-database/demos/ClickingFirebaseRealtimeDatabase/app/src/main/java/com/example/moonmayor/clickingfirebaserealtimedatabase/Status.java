package com.example.moonmayor.clickingfirebaserealtimedatabase;

public class Status {
    public enum AwayStatus {
        ONLINE, AWAY, OFFLINE
    }

    public String username;
    public AwayStatus status;      // one of "online", "away", "offline"
    public String statusText;      // "I'm grabbing a sandwhich"

    public Status(String username, AwayStatus status, String statusText) {
        this.username = username;
        this.status = status;
        this.statusText = statusText;
    }
}
