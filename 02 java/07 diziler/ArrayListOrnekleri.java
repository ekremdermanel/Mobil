package com.example.diziler;

import java.util.ArrayList;

public class ArrayListOrnekleri {
    public static void main(String[] args) {
        ArrayList<Integer> sayilar = new ArrayList<>();
        sayilar.add(5);
        sayilar.add(10);
        sayilar.add(8);
        sayilar.add(2);
        sayilar.add(2, 15);

        sayilar.remove(2);
        sayilar.set(1, 30);

        System.out.println("Ilk sayi: " + sayilar.get(0));

        System.out.println();
        System.out.println("--\nTum Sehirler\n---");
        for (int i = 0; i < sayilar.size(); i++) {
            System.out.println(sayilar.get(i));
        }

        System.out.println();
        System.out.println("--\nTum Sehirler\n---");
        for (int sayi : sayilar) {
            System.out.println(sayi);
        }
    }
}
