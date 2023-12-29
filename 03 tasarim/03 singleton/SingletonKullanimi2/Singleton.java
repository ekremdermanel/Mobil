package com.example.singletonkullanimi;

public class Singleton {

    private Ogrenci ogrenci = new Ogrenci();

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    private static Singleton singleton;

    public static Singleton getInstance(){
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
