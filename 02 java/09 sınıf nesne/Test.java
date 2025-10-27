package com.example.siniflar;

public class Test {
    public static void main(String[] args) {
        Ogrenci ogr1 = new Ogrenci();
        ogr1.adSoyad="Ali Sari";
        ogr1.sinav1=50;
        ogr1.sinav2=30;
        System.out.println("1. ogrenci ort: " + ogr1.ortalamaHesapla());
        System.out.println("1. ogrenci bilgileri: " + ogr1.ogrenciKarti());

        Ogrenci ogr2 = new Ogrenci();
        ogr2.adSoyad="Ayse Kara";
        ogr2.sinav1=100;
        ogr2.sinav2=81;
        System.out.println("2. ogrenci ort: " + ogr2.ortalamaHesapla());
        System.out.println("2. ogrenci bilgileri: " + ogr2.ogrenciKarti());

        Ogrenci ogr3 = new Ogrenci();
        ogr3.adSoyad="Ayse Kara";
        System.out.println("3. ogrenci ort: " + ogr3.ortalamaHesapla());
        System.out.println("3. ogrenci bilgileri: " + ogr3.ogrenciKarti());

        Ogrenci ogr4 = new Ogrenci(20,30);
        ogr4.adSoyad="Ayse Kara";
        System.out.println("4. ogrenci ort: " + ogr4.ortalamaHesapla());
        System.out.println("4. ogrenci bilgileri: " + ogr4.ogrenciKarti());

        Ogrenci ogr5 = new Ogrenci(80);
        ogr5.adSoyad="Ayse Kara";
        System.out.println("5. ogrenci ort: " + ogr5.ortalamaHesapla());
        System.out.println("5. ogrenci bilgileri: " + ogr5.ogrenciKarti());

        Ogrenci ogr6 = new Ogrenci("Kazım Kara",60,75);
        System.out.println("6. ogrenci ort: " + ogr6.ortalamaHesapla());
        System.out.println("6. ogrenci bilgileri: " + ogr6.ogrenciKarti());
    }
}
