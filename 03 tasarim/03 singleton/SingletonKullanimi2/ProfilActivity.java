package com.example.singletonkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        TextView textView1 = findViewById(R.id.textView1);
        ImageView imageView = findViewById(R.id.imageView);
        Ogrenci ogrenci = Singleton.getInstance().getOgrenci();
        textView1.setText(ogrenci.adSoyad + " (" + ogrenci.yas + ")");
        if (ogrenci.cinsiyet == "erkek") {
            imageView.setBackgroundColor(Color.BLUE);
        } else {
            imageView.setBackgroundColor(Color.RED);
        }
    }

    public void geri(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}