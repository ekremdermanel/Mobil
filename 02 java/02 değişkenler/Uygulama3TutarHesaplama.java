package com.example.uygulama2526;

public class Uygulama3TutarHesaplama {
    public static void main(String[] args) {
        double birimFiyat = 32.43;
        int adet = 4;
        final int KDV = 18;
        double tutar = birimFiyat * adet;
        System.out.println("Tutar: " + tutar);
        double vergi = tutar * KDV /100;
        System.out.println("Vergi: " + vergi);
        System.out.println("Toplam Tutar: " + (tutar + vergi));
    }
}
