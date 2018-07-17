package com.company;

import com.company.ciphers.KeywordCipher;

public class VariableParameter {
    public static final String alphabet = "abcdefgh";

    public static void method() {
        alphabet.length();

        KeywordCipher kk = new KeywordCipher("java");
        kk.encode("ace");
    }
}

