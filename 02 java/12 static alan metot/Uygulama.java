package com.example.staticalanmetot;

public class Uygulama {
    public static void main(String[] args) {
        System.out.println("Ogrenci sayisi: " + Ogrenci.ogrenciSayisi);

        Ogrenci ogr1 = new Ogrenci();
        ogr1.numara=10;
        ogr1.adSoyad="Ahmet Kara";
        ogr1.cinsiyet="erkek";
        System.out.println(ogr1.ogrenciBilgisi());
        System.out.println(Ogrenci.sinifBilgisi());

        Ogrenci ogr2 = new Ogrenci();
        ogr2.numara=20;
        ogr2.adSoyad="Ayse Sari";
        ogr2.cinsiyet="kiz";
        System.out.println(ogr2.ogrenciBilgisi());
        System.out.println(Ogrenci.sinifBilgisi());

        /*
        Math.sqrt(25);
        Math.pow(6,2);
        double pi_sayisi = Math.PI;
        */

        System.out.println(Matematik.karesi(8)); // 64
        System.out.println(Matematik.mutlak(-15)); // 15
        System.out.println(Matematik.FAVORI_SAYIM); // 5


        /*
        String cumle = "merhaba dostum";
        cumle.charAt(2); // r
        cumle.substring(2,5); // rha
        */

        System.out.println(Metin.uzunluk("Ahmet")); // 5
        System.out.println(Metin.ilkKarakter("Ahmet")); // A
        System.out.println(Metin.ilkUcKarakter("Ahmet")); // Ahm

        Doviz.dolarKuru=25.0;
        System.out.println(Doviz.dolarToTl(10.0) + "TL"); // 250.0
        System.out.println(Doviz.tlToDolar(500.0) + "$"); // 20.0





    }
}
