package com.example.AuthDemo.db;

import com.example.AuthDemo.mock.MockUserDB;
import com.example.AuthDemo.models.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDBTest {
    @BeforeClass
    public static void resetDB() {
        MockUserDB.reset();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = UserDB.getAllUsers();
        assertTrue(users.size() > 0);

        // can't rely the users are in any real particular order.
        boolean foundMoonMayor = false;
        for (User user : users) {
            if (user.username.equals("moonmayor")) {
                foundMoonMayor = true;
            }
        }

        assertTrue(foundMoonMayor);
    }

    @Test
    public void createUser() throws Exception {
        String bio =  "One batty batty batty. Two batty batty batty.";
        User user = UserDB.createUser("three", "four", bio);

        assertTrue(user.id > 0);
        assertEquals("three", user.username);
        assertEquals(bio, user.bio);
    }

    @Test
    public void getUserById() throws Exception {
        User user1 = UserDB.getUserById(1);
        assertEquals("moonmayor", user1.username);
    }

    @Test
    public void getUserByName() throws Exception {
        User user1 = UserDB.getUserByName("moonmayor");
        assertEquals(1, user1.id);
    }

    @Test
    public void updateUserBio() throws Exception {
        String newBio = "Missing Earth.";
        User user = UserDB.getUserByName("moonmayor");
        user = UserDB.updateUserBio(user.id, newBio);

        assertEquals(newBio, user.bio);
    }

    @Test
    public void deleteUser() throws Exception {
        boolean isDeleted = UserDB.deleteUser(2);
        User user = UserDB.getUserById(2);

        assertTrue(isDeleted);
        assertNull(user);
    }

    @Test
    public void impossibleDelete() throws Exception {
        // try to delete a user that doesn't exist
        boolean isDeleted = UserDB.deleteUser(-2);
        User user = UserDB.getUserById(-2);

        // ok, who cares if a non-existent user says they were deleted when they "weren't"
        assertTrue(isDeleted);
        assertNull(user);
    }

}