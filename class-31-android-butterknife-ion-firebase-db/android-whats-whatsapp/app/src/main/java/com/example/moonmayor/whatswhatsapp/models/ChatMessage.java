package com.example.moonmayor.whatswhatsapp.models;

import java.util.Date;

/**
 * Created by moonmayor on 10/4/17.
 */

public class ChatMessage {
    public final String username;
    public final String message;
    public final long timestamp;

    // fake some delay of time for messages that are created without a real timestamp.
    private static long fakeIncrementingTimeDelay = 0L;
    private static long fakeTimeDelayIncrement = 10000L;

    public ChatMessage(String username, String message, long timestamp) {
        this.username = username;
        this.message = message;
        this.timestamp = timestamp;
    }

    public ChatMessage(String username, String message) {
        this(username, message, (new Date()).getTime() + fakeIncrementingTimeDelay);
        fakeIncrementingTimeDelay += fakeTimeDelayIncrement;
    }
}
