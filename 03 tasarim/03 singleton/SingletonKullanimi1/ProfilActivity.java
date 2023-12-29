package com.example.singletonkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        TextView textView1 = findViewById(R.id.textView1);
        String adSoyad = Singleton.getInstance().getAdSoyad();
        int yas = Singleton.getInstance().getYas();
        textView1.setText(adSoyad + " (" + yas + ")");
    }

    public void geri(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}