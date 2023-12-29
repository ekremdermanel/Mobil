package com.example.staticalanmetot;

public class Matematik {
    static final int FAVORI_SAYIM = 5;

    static int karesi(int sayi) {
        return sayi * sayi;
    }

    static int mutlak(int sayi) {
        if(sayi>=0) {
            return sayi;
        } else {
            return -1 * sayi;
        }
    }
}
