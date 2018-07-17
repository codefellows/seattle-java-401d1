package com.company;

import com.company.ciphers.KeywordCipher;

import java.security.Key;

public class MainTwo {
    public static void main(String[] args) {
        KeywordCipher k1 = new KeywordCipher("moon");
        k1.encode("the eagle has landed");

        KeywordCipher k2 = new KeywordCipher("apollo");
        k2.encode("the eagle has landed");

        KeywordCipher.encode("nasa", "the eagle has landed");
        KeywordCipher.encode("nasa", "we've got liftoff");
        KeywordCipher.encode("nasa", "oops, we've done it again");
    }
}
