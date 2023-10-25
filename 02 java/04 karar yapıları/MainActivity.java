package com.example.kararyapilari;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editKullanici, editSifre;
    Button buttonGiris;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editKullanici = findViewById(R.id.editKullanici);
        editSifre = findViewById(R.id.editSifre);
        buttonGiris = findViewById(R.id.buttonGiris);

        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kullanici = editKullanici.getText().toString();
                String sifre = editSifre.getText().toString();
                if (kullanici.equals("admin") && sifre.equals("admin123"))
                {
                    Toast.makeText(MainActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}