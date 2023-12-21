package com.example.kalitim;

public class Arac {
    protected String marka;
    String model;
    int motorHacmi;

    String calis() {
        return "Arac calisti";
    }

    String dur() {
        return "Arac durdu";
    }

    String aracBilgileri() {
        return marka + " " + model + " " + motorHacmi + " motor";
    }
}
