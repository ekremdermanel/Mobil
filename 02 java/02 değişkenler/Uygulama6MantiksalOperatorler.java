package com.example.uygulama2526;

public class Uygulama6MantiksalOperatorler {
    public static void main(String[] args) {
        // Değişkenler
        boolean isSicak = true;
        boolean yagmurVar = false;

        // NOT operatörü (!)
        System.out.println("Hava sıcak değil mi? " + !isSicak); // false

        // AND operatörü (&&)
        System.out.println("Hava sıcak ve yağmur yok mu? " + (isSicak && !yagmurVar)); // true

        // OR operatörü (||)
        System.out.println("Hava sıcak veya yağmur var mı? " + (isSicak || yagmurVar)); // true

        // AND ve OR kombinasyonu
        boolean disaridaOyna = isSicak && !yagmurVar || false;
        System.out.println("Dışarıda oynanabilir mi? " + disaridaOyna); // true

        // Karışık örnek
        boolean tatilGunu = false;
        boolean siniftaCalis = !tatilGunu && (isSicak || yagmurVar);
        System.out.println("Sınıfta çalışmalı mı? " + siniftaCalis); // true
    }
}
