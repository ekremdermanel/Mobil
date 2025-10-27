package com.example.siniflar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        textView1 = findViewById(R.id.textView1);
    }

    public void yazdir(View view) {
        Ogrenci ogrenci = new Ogrenci();
        ogrenci.adSoyad = editText1.getText().toString();
        ogrenci.sinav1 = Integer.parseInt(editText2.getText().toString());
        ogrenci.sinav2 = Integer.parseInt(editText3.getText().toString());
        textView1.setText(ogrenci.ogrenciKarti());
        if(ogrenci.ortalamaHesapla() >= 50) {
            textView1.setTextColor(Color.parseColor("#00ff00"));
        } else {
            textView1.setTextColor(Color.parseColor("#ff0000"));
        }
    }
}

