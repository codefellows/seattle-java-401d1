package com.example.moonmayor.whatswhatsapp.mockdata;

import com.example.moonmayor.whatswhatsapp.models.ChatMessage;
import com.example.moonmayor.whatswhatsapp.models.ChatConversation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moonmayor on 10/4/17.
 */

public class MockConversations {
    private static List<String> participants = new ArrayList<>();

    private static ChatMessage chat1 = new ChatMessage("Alice", "Hey Bob, I have something to tell you.");
    private static ChatMessage chat2 = new ChatMessage("Bobby", "OK, tell me!");
    private static ChatMessage chat3 = new ChatMessage("Alice", "We have to be careful. It's a secret.");
    private static ChatMessage chat4 = new ChatMessage("Bobby", "Hmm. I'm not sure how to send secrets.");
    private static ChatMessage chat5 = new ChatMessage("Alice", "lol");
    private static ChatMessage chat6 = new ChatMessage("Bobby", "lol");
    private static ChatMessage chat7 = new ChatMessage("Alice", "lol");
    private static ChatMessage chat8 = new ChatMessage("Bobby", "lol");
    private static ChatMessage chat9 = new ChatMessage("Alice", "lol");
    private static ChatMessage chat10 = new ChatMessage("Bobby", "lol");
    private static ChatMessage chat11 = new ChatMessage("Alice", "lol");
    private static ChatMessage chat12 = new ChatMessage("Bobby", "lol");

    private static List<ChatMessage> emptyConvoMessages = new ArrayList<>();
    private static List<ChatMessage> shortConvoMessages = new ArrayList<>();
    private static List<ChatMessage> longConvoMessages = new ArrayList<>();

    public static ChatConversation emptyConversation;
    public static ChatConversation shortConversation;
    public static ChatConversation longConversation;

    public static List<ChatConversation> allConversations = new ArrayList<>();

    static {
        participants.add("Alice");
        participants.add("Bobby");

        emptyConversation = new ChatConversation("Empty Convo", participants, emptyConvoMessages);

        shortConvoMessages.add(chat1);
        shortConvoMessages.add(chat2);
        shortConvoMessages.add(chat3);
        shortConversation = new ChatConversation("Short Convo", participants, shortConvoMessages);

        longConvoMessages.add(chat1);
        longConvoMessages.add(chat2);
        longConvoMessages.add(chat3);
        longConvoMessages.add(chat4);
        longConvoMessages.add(chat5);
        longConvoMessages.add(chat6);
        longConvoMessages.add(chat7);
        longConvoMessages.add(chat8);
        longConvoMessages.add(chat9);
        longConvoMessages.add(chat10);
        longConvoMessages.add(chat11);
        longConvoMessages.add(chat12);
        longConversation = new ChatConversation("Long Convo", participants, longConvoMessages);

        allConversations.add(emptyConversation);
        allConversations.add(shortConversation);
        allConversations.add(longConversation);
    }

    public static ChatConversation getConversationByTitle(String title) {
        for (ChatConversation conversation : allConversations) {
            if (conversation.title.equals(title)) {
                return conversation;
            }
        }
        return new ChatConversation();
    }
}
