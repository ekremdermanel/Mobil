package com.example.kalitim;

public class Ucgen extends Sekil{
    public Ucgen(int genislik, int yukselik) {
        super(genislik, yukselik);
    }

    @Override
    int alan() {
        return super.alan() / 2;
    }
}
