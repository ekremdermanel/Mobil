package com.example.metotlar;

import java.util.Random;

public class Ornek {
    public static void main(String[] args) {
        selamla();
        selamla();

        kisiSelamla("Ahmet");
        kisiSelamla("Ayşe");

        int rastgele;
        rastgele = rastgeleSayi();
        System.out.println("Rastgele sayı: " + rastgele);
        rastgele = rastgeleSayi();
        System.out.println("Rastgele sayı: " + rastgele);

        float ortalama;
        ortalama = ortalamaHesapla(10,7);
        System.out.println("Ortalama: " + ortalama);
        ortalama = ortalamaHesapla(20,30);
        System.out.println("Ortalama: " + ortalama);
    }

    static float ortalamaHesapla(int sayi1, int sayi2) {
        System.out.println("Değer döndüren parametreli metot çağrıldı");
        float ort = (float) (sayi1 + sayi2) / 2 ;
        return ort;
    }

    static int rastgeleSayi() {
        System.out.println("Değer döndüren metot çağrıldı");
        Random rastgele = new Random();
        int sayi = rastgele.nextInt(20);
        return sayi;
    }

    static void kisiSelamla(String isim) {
        System.out.println("Değer döndürmeyen parametreli metot çağrıldı");
        System.out.println("Merhaba " + isim);
    }

    static void selamla() {
        System.out.println("Değer döndürmeyen metot çağrıldı");
        System.out.println("Merhaba");
    }

}
