package com.example.uygulama2526;

public class Uygulama5KarsilastirmaOperatorleri {
    public static void main(String[] args) {
        // Sayı değişkenleri
        int sayi1 = 10;
        int sayi2 = 5;
        int sayi3 = 10;

        // Karşılaştırma operatörleri
        System.out.println("sayi1 > sayi2: " + (sayi1 > sayi2));   // true
        System.out.println("sayi1 < sayi2: " + (sayi1 < sayi2));   // false
        System.out.println("sayi1 >= sayi3: " + (sayi1 >= sayi3)); // true
        System.out.println("sayi1 <= sayi2: " + (sayi1 <= sayi2)); // false
        System.out.println("sayi1 == sayi3: " + (sayi1 == sayi3)); // true
        System.out.println("sayi1 != sayi2: " + (sayi1 != sayi2)); // true

        System.out.println("----------------------------");

        // Mantıksal operatörler ile kombinasyon
        System.out.println("(sayi1 > sayi2) && (sayi1 == sayi3): " + ((sayi1 > sayi2) && (sayi1 == sayi3))); // true
        System.out.println("(sayi1 < sayi2) || (sayi1 == sayi3): " + ((sayi1 < sayi2) || (sayi1 == sayi3))); // true
        System.out.println("!((sayi1 != sayi3) && (sayi2 < sayi3)): " + (!((sayi1 != sayi3) && (sayi2 < sayi3)))); // false
    }
}
