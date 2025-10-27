package com.example.recyclerviewornek;

import java.io.Serializable;

public class Urun implements Serializable {
    String urunKodu;
    String urunAdi;
    double fiyat;
    int stok;

    public Urun() {
    }
    public Urun(String urunKodu, String urunAdi, double fiyat, int stok) {
        this.urunKodu = urunKodu;
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.stok = stok;
    }
}
