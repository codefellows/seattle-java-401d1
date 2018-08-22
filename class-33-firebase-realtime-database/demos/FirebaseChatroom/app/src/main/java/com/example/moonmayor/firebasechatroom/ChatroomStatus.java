package com.example.moonmayor.firebasechatroom;

public class ChatroomStatus {
    public String username;
    public String status;
    public String statusText;

    public ChatroomStatus() {}

    public ChatroomStatus(String name, String status, String text) {
        this.username = name;
        this.status = status;
        this.statusText = text;
    }

    public String toString() {
        String format = "%s (%s): %s";
        return String.format(format, this.username, this.status, this.statusText);
    }
}
