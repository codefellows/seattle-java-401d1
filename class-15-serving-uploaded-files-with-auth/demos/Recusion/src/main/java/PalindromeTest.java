package main.java;

import com.sun.source.tree.AssertTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PalindromeTest {

    @org.junit.Test
    public void isPalindrome() {
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("aa"));
        assertTrue(Palindrome.isPalindrome("asa"));
        assertTrue(Palindrome.isPalindrome("aabbaa"));
        assertTrue(Palindrome.isPalindrome("tacocat"));
        assertTrue(Palindrome.isPalindrome("racecar"));
        assertTrue(Palindrome.isPalindrome("lionoil"));
        assertTrue(Palindrome.isPalindrome("lionoil"));
    }

    @org.junit.Test
    public void notPalindromes() {
        assertFalse(Palindrome.isPalindrome("as"));
        assertFalse(Palindrome.isPalindrome("another"));
    }

    @org.junit.Test
    public void largeFile() throws Exception {
        File file = new File("/Users/moonmayor/Fellows/one-java/seattle-java-401d1/class-15-serving-uploaded-files-with-auth/demos/Recusion/src/resources/palin.txt");
        Scanner scanner = new Scanner(file);

        String contents = "";
        while (scanner.hasNextLine()) {
            contents += scanner.nextLine();
        }
        assertTrue(Palindrome.isPalindrome(contents));
    }
}