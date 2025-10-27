package com.example.kalitim;

public class Kamyon extends Arac {
    int azamiYuk;

    String yukTasi(int yuk) {
        return yuk + " kg tasindi.";
    }

    @Override
    String aracBilgileri() {
        return super.aracBilgileri() + ", azami " + azamiYuk + " kg";
    }
}
