package com.example.uygulama2526;

public class Uygulama4AritmetikselOperatorler {
    public static void main(String[] args) {
        int sayi1 = 20;
        int sayi2 = 6;

        System.out.println("Başlangıç Değerleri:");
        System.out.println("sayi1 = " + sayi1);
        System.out.println("sayi2 = " + sayi2);
        System.out.println("-------------------------");

        // Temel aritmetik operatörleri
        int toplam = sayi1 + sayi2;
        int fark = sayi1 - sayi2;
        int carpim = sayi1 * sayi2;
        int bolum = sayi1 / sayi2;
        int kalan = sayi1 % sayi2;

        System.out.println("Toplama: " + toplam);
        System.out.println("Çıkarma: " + fark);
        System.out.println("Çarpma: " + carpim);
        System.out.println("Bölme (tam sayı): " + bolum);
        System.out.println("Mod (kalan): " + kalan);
        System.out.println("-------------------------");

        // Ondalıklı bölme
        double bolumOndalik = (double) sayi1 / sayi2;
        System.out.println("Bölme (ondalıklı): " + bolumOndalik);
        System.out.println("-------------------------");

        // Artırma ve azaltma operatörleri
        sayi1++; // sayi1 = 21
        sayi2--; // sayi2 = 5
        System.out.println("sayi1++ sonrası: " + sayi1);
        System.out.println("sayi2-- sonrası: " + sayi2);
        System.out.println("-------------------------");

        // Atama operatörleri (+=, -=, *=, /=, %=)
        sayi1 += 10;   // sayi1 = sayi1 + 10
        System.out.println("sayi1 += 10 --> " + sayi1);

        sayi1 -= 5;    // sayi1 = sayi1 - 5
        System.out.println("sayi1 -= 5  --> " + sayi1);

        sayi1 *= 2;    // sayi1 = sayi1 * 2
        System.out.println("sayi1 *= 2  --> " + sayi1);

        sayi1 /= 3;    // sayi1 = sayi1 / 3
        System.out.println("sayi1 /= 3  --> " + sayi1);

        sayi1 %= 4;    // sayi1 = sayi1 % 4
        System.out.println("sayi1 %= 4  --> " + sayi1);
        System.out.println("-------------------------");

        // Karma bir işlem
        int sonuc = (10 + 5) * 2 - 8 / 2 + (3 % 2);
        System.out.println("Karma işlem sonucu: " + sonuc);
    }
}
