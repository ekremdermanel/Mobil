package com.example.uygulama2526;

public class Uygulama2DaireHesaplama {
    public static void main(String[] args) {
        // Sabit tanımı
        final float PI_SAYISI = 3.14f;

        // Yarıçap değişkeni
        int yaricap = 5;

        // Çevre = 2 * π * r
        float cevre = 2 * PI_SAYISI * yaricap;

        // Alan = π * r * r
        float alan = PI_SAYISI * yaricap * yaricap;

        // Sonuçları ekrana yazdır
        System.out.println("Yarıçap: " + yaricap);
        System.out.println("Dairenin çevresi: " + cevre);
        System.out.println("Dairenin alanı: " + alan);
    }
}
