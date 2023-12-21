package com.example.kalitim;

public class Otobus extends Arac{
    int yolcuSayisi;

    String yolculukYap() {
        return marka +  "Yolculuk yapildi.";
    }

    String yolcuAl(int yolcu) {
        return yolcu + " yolcu alindi.";
    }
}
