package com.example.moonmayor.whatswhatsapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moonmayor on 10/4/17.
 */

public class ChatConversation {
    public final String title;
    public final List<ChatMessage> messages;
    public final List<String> participants;

    public ChatConversation() {
        this("Untitled", new ArrayList<String>(), new ArrayList<ChatMessage>());
    }

    public ChatConversation(String title, List<String> participants, List<ChatMessage> messages) {
        this.title = title;
        this.participants = participants;
        this.messages = messages;
    }
}
