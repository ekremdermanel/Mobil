package com.example.kalitim;

public class Uygulama {
    public static void main(String[] args) {
        Otomobil oto1 = new Otomobil();
        oto1.marka="Fiat";
        oto1.model="Egea";
        oto1.motorHacmi=1600;
        oto1.yolcuSayisi=5;
        oto1.kapiSayisi=4;
        System.out.println(oto1.aracBilgileri());
        System.out.println(oto1.calis());
        System.out.println(oto1.dur());
        System.out.println(oto1.yolculukYap());

        Kamyon kamyon1 = new Kamyon();
        kamyon1.marka="Mercedes";
        kamyon1.model="E100";
        kamyon1.motorHacmi=3000;
        kamyon1.azamiYuk=500;
        System.out.println(kamyon1.aracBilgileri());
        System.out.println(kamyon1.calis());
        System.out.println(kamyon1.dur());
        System.out.println(kamyon1.yukTasi(100));

        Arac testere = new Arac();
        testere.marka="Bosch";
        testere.model="B34";
        testere.motorHacmi=100;
        System.out.println(testere.aracBilgileri());



        Sekil s = new Sekil(5,8);

    }
}
