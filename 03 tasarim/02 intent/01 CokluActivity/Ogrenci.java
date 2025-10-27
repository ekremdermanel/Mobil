package com.example.myapplication;

public class Ogrenci implements Serializable {
    int numara;
    String adSoyad;
    String cinsiyet;

    @Override
    public String toString() {
        return numara + " " + adSoyad + " " + cinsiyet;
    }
}
