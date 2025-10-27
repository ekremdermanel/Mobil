package com.example.singletonkullanimi;

public class Singleton {

    private String adSoyad;

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    private int yas;

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    private static Singleton singleton;

    public static Singleton getInstance(){
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
