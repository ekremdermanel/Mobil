package com.example.siniflar;

public class Ogrenci {
    String adSoyad;
    int sinav1;
    int sinav2;

    public Ogrenci() {
        sinav1=50;
        sinav2=50;
    }

    public Ogrenci(int sinav) {
        sinav1=sinav;
        sinav2=sinav;
    }

    public Ogrenci(int sinav1, int sinav2) {
        this.sinav1 = sinav1;
        this.sinav2 = sinav2;
    }

    public Ogrenci(String adSoyad, int sinav1, int sinav2) {
        this.adSoyad=adSoyad;
        this.sinav1 = sinav1;
        this.sinav2 = sinav2;
    }

    float ortalamaHesapla() {
        float ort = (float)(sinav1 + sinav2) / 2;
        return ort;
    }

    String ogrenciKarti() {
        if (ortalamaHesapla() >= 50) {
            return adSoyad + " Basarili Bir Ogrenci";
        } else {
            return adSoyad + " Basarisiz Bir Ogrenci";
        }
    }


}
