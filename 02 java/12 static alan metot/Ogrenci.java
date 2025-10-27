package com.example.staticalanmetot;

public class Ogrenci {
    int numara;
    String adSoyad;
    String cinsiyet;

    static int ogrenciSayisi;

    String ogrenciBilgisi() {
        return ogrenciSayisi + " kisilik siniftaki " + adSoyad;
    }

    static String sinifBilgisi() {
        return "Bu sinifta " + ogrenciSayisi + " ogrenci var";
    }

    public Ogrenci() {
        ogrenciSayisi++;
    }

}
