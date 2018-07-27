package main.java;

public class Palindrome {
    public static String LETTERS = "qwertyuiopasdfghjklzxcvbnm";

    // ""
    // "a"
    // "asa"
    // tacocat
    // racecar
    public static boolean isPalindrome(String ss) {
        return isPalindrome(ss.toLowerCase(), 0, ss.length() - 1);
    }

    private static boolean isPalindrome(String ss, int first, int last) {
        if (last < first) {
            return true;
        }

        char c1 = ss.charAt(first);
        char c2 = ss.charAt(last);
        System.out.println(c1 + " " + c2);

        // ignore anything that's not a letter
        if (!LETTERS.contains("" + c1)) {
           isPalindrome(ss, first + 1, last);
        }
        if (!LETTERS.contains("" + c2)) {
            isPalindrome(ss, first, last - 1);
        }

        if (c1 != c2) {
            return false;
        }
        return isPalindrome(ss, first + 1, last - 1);
    }
}
