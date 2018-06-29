package com.example.AuthDemo.mock;

import com.example.AuthDemo.models.User;

import java.util.ArrayList;
import java.util.List;

public class MockUserDB {
    private static List<User> users;

    static {
        reset();
    }

    public static void reset() {
        users = new ArrayList<>();
        users.add(new User("Bruce Wayne", "batman", "Gotham's vigilant vigilante."));
        users.add(new User("Clark Kent", "superman", "A hero from another world"));
        users.add(new User("Joe Schmoe", "workingman", "True American hero."));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static User getUser(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (("" + i).equals(id)) {
                return users.get(i);
            }
        }
        return null;
    }

    public static User createUser(String username, String password, String bio) {
        User user = new User(username, password, bio);
        users.add(user);
        return user;
    }

    // users are only allowed to update their bio.
    // they can't change their name or their password, sorry!
    public static User editUser(String id, String bio) {
        User user = getUser(id);
        user.bio = bio;
        return user;
    }

    public static User getUserByName(String name) {
        for (User user : users) {
            if (user.username.equals(name)) {
                return user;
            }
        }
        return null;
    }

    public static boolean deleteUser(String id) {
        User user = getUser(id);
        if (user != null) {
            return users.remove(user);
        }
        return false;
    }
}
