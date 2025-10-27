package com.example.staticalanmetot;

public class Doviz {
    static double dolarKuru = 1;

    static double dolarToTl(double dolar) {
        return dolar * dolarKuru;
    }

    static double tlToDolar(double tl) {
        return tl / dolarKuru;
    }
}
