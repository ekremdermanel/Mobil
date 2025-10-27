package com.example.kalitim;

public class Sekil {
    private int genislik;
    private int yukselik;

    public Sekil(int genislik, int yukselik) {
        this.genislik = genislik;
        this.yukselik = yukselik;
    }

    int alan() {
        return genislik * yukselik;
    }

    @Override
    public String toString() {
        return "Sekil alani " + alan();
    }
}
