package com.example.uygulama2526;

public class Uygulama1DikdortgenHesapla {
    public static void main(String[] args) {
        // Değişken tanımları
        int kisaKenar = 5;
        int uzunKenar = 8;

        // Alan ve çevre hesaplamaları
        int alan = kisaKenar * uzunKenar;
        int cevre = 2 * (kisaKenar + uzunKenar);

        // Sonuçları ekrana yazdırma
        System.out.println("Kısa Kenar: " + kisaKenar);
        System.out.println("Uzun Kenar: " + uzunKenar);
        System.out.println("Dikdörtgenin Alanı: " + alan);
        System.out.println("Dikdörtgenin Çevresi: " + cevre);
    }
}
