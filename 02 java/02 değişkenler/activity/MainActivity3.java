package com.example.uygulama2526;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    EditText editSayi1, editSayi2;
    TextView textSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editSayi1 = findViewById(R.id.editSayi1);
        editSayi2 = findViewById(R.id.editSayi2);
        textSonuc = findViewById(R.id.textSonuc);
    }

    // Toplama
    public void topla(View view) {
        int sayi1 = Integer.parseInt(editSayi1.getText().toString());
        int sayi2 = Integer.parseInt(editSayi2.getText().toString());
        int sonuc = sayi1 + sayi2;
        textSonuc.setText("Toplam: " + sonuc);
    }

    // Çıkarma
    public void cikar(View view) {
        int sayi1 = Integer.parseInt(editSayi1.getText().toString());
        int sayi2 = Integer.parseInt(editSayi2.getText().toString());
        int sonuc = sayi1 - sayi2;
        textSonuc.setText("Fark: " + sonuc);
    }

    // Çarpma
    public void carp(View view) {
        int sayi1 = Integer.parseInt(editSayi1.getText().toString());
        int sayi2 = Integer.parseInt(editSayi2.getText().toString());
        int sonuc = sayi1 * sayi2;
        textSonuc.setText("Çarpım: " + sonuc);
    }

    // Bölme
    public void bol(View view) {
        int sayi1 = Integer.parseInt(editSayi1.getText().toString());
        int sayi2 = Integer.parseInt(editSayi2.getText().toString());
        int sonuc = sayi1 / sayi2;
        textSonuc.setText("Bölüm: " + sonuc);
    }

    // Kalan (mod)
    public void kalan(View view) {
        int sayi1 = Integer.parseInt(editSayi1.getText().toString());
        int sayi2 = Integer.parseInt(editSayi2.getText().toString());
        int sonuc = sayi1 % sayi2;
        textSonuc.setText("Kalan: " + sonuc);
    }

}