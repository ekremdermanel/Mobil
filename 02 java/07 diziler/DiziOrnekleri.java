package com.example.diziler;

public class DiziOrnekleri {
    public static void main(String[] args) {

        int sayi;
        sayi=5;
        sayi=10;
        System.out.println("Sayi degeri: " + sayi);

        int[] sayilar = new int[3];
        sayilar[0] = 5;
        sayilar[1] = 10;
        sayilar[2] = 8;
        System.out.println("Ilk sayi degeri: " + sayilar[0]);

        //String[] sehirler = new String[] {"Istanbul","Ankara","Izmir","Erzurum","Canakkale"};
        String[] sehirler = {"Istanbul","Ankara","Izmir","Erzurum","Canakkale"};
        sehirler[1] = "Denizli";
        sehirler[4] = "Trabzon";
        System.out.println("Son sehir degeri: " + sehirler[4]);
        System.out.println("Sehir sayisi: " + sehirler.length);

        System.out.println();
        System.out.println("--\nTum Sehirler\n---");
        for (int i = 0; i < sehirler.length; i++) {
            System.out.println(sehirler[i]);
        }

        System.out.println();
        System.out.println("--\nTum Sehirler\n---");
        for (String sehir : sehirler) {
            System.out.println(sehir);
        }

    }
}
