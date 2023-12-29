package com.example.staticalanmetot;

public class Metin {
    static int uzunluk(String metin) {
        return metin.length();
    }

    static char ilkKarakter(String metin) {
        return metin.charAt(0);
    }

    static String ilkUcKarakter(String metin) {
        if(uzunluk(metin)>=3) {
            return metin.substring(0,3);
        } else {
            return metin;
        }

    }
}
