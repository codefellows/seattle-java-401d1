package com.company.ciphers;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InheritanceExample {
    public static void main(String[] args) {
        Shape ss = new Rectangle();

        List<Cipher> ll = new ArrayList();

        Cipher rot13 = new ROT13Cipher();
        Cipher cc = new CaesarShiftCipher(3);

        ll.add(rot13);
        ll.add(cc);

        encodeAndPrint(rot13, "secret message");
        encodeAndPrint(cc, "secret message");

        ROT13Cipher ccc = (ROT13Cipher) ll.get(0);
    }

    public static void encodeAndPrint(Cipher cipher, String message) {
        String encoded = cipher.encode(message);
        System.out.println(encoded);
    }
}
