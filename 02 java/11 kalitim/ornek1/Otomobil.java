package com.example.kalitim;

public class Otomobil extends Arac {
    int kapiSayisi;
    int yolcuSayisi;

    String yolculukYap() {
        return "Yolculuk yapildi.";
    }

    @Override
    String aracBilgileri() {
        return super.aracBilgileri() + ", " + yolcuSayisi + " yolcu, " + kapiSayisi + " kapi";
    }
}
