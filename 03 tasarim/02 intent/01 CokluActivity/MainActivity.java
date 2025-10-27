package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gonder(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void veriGonder(View view) {
        Intent intent = new Intent(this,MainActivity3.class);
        intent.putExtra("isim","Ahmet");
        intent.putExtra("numara", 96);
        startActivity(intent);
    }

    public void nesneGonder(View view) {
	Ogrenci ogrenci = new Ogrenci();
        ogrenci.numara=20;
        ogrenci.adSoyad="Ahmet Kara";
        ogrenci.cinsiyet="erkek";
        Intent intent = new Intent(this,MainActivity4.class);
        intent.putExtra("ogrenci",ogrenci);
        startActivity(intent);
    }
}