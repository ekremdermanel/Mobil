package com.example.kapsulleme;

import android.util.Log;

public class Personel {
    private String adSoyad;
    private int yas;
    public void setYas(int yas) {
        if(yas>=18 && yas<=65) {
            this.yas = yas;
        } else {
            Log.e("Hata","Yas degeri hatali");
        }
    }
    public int getYas() {
        return yas;
    }

    public String getAdSoyad() {
        return "Sayin " + adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    String personelBilgileri() {
        return adSoyad + ", " + yas + " yasinda";
    }
}
