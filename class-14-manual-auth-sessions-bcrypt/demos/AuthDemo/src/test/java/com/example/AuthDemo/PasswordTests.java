package com.example.AuthDemo;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PasswordTests {
    @Test
    public void testCorectPass() {
        String password = "password";
        String wrongPassword = "nopenope";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        assertTrue(BCrypt.checkpw(password, hashed));
        assertFalse(BCrypt.checkpw(wrongPassword, hashed));
    }

    @Test
    public void precomputedPasswords() {
        String password = "sun";

        // These hashes were computed from previous salts.
        // This test shows that different hashes will be generated, but they'll
        // still check truly against the original password.
        String h1 = "$2a$12$u7s.Q60pWu01Yujt6KH4wuX8Dcf9Pm1PlwEoQcGXhHrpYzRH53.Se";
        String h2 = "$2a$12$UZUjz5zVWgOHCQdnSLix3u5HkJy0cB7GEpqCaGYDt4JPZ4gi6SbXS";
        String h3 = "$2a$12$q8VCJQNHZzKQz023r/WqGev2M8R2aVCWsCnhgZx5eq7YnHVPTudGy";
        String h4 = BCrypt.hashpw(password, BCrypt.gensalt(12));

        assertTrue(BCrypt.checkpw(password, h1));
        assertTrue(BCrypt.checkpw(password, h2));
        assertTrue(BCrypt.checkpw(password, h3));
        assertTrue(BCrypt.checkpw(password, h4));
    }
}
