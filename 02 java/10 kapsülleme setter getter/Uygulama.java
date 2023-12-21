package com.example.kapsulleme;

public class Uygulama {
    public static void main(String[] args) {
        Personel personel = new Personel();
        personel.setAdSoyad("Ahmet Sari");
        personel.setYas(40);
        System.out.println("Adi: " + personel.getAdSoyad());
        System.out.println("Yasi: " + personel.getYas());
        System.out.println(personel.personelBilgileri());
    }
}
