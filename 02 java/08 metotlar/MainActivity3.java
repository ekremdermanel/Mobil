package com.example.metotlar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4;
    EditText editIsim, editSayi1,editSayi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        editIsim = findViewById(R.id.editIsim);
        editSayi1 = findViewById(R.id.editSayi1);
        editSayi2 = findViewById(R.id.editSayi2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selamla();
            }
        });
    }

    float ortalamaHesapla(int sayi1, int sayi2) {
        System.out.println("Değer döndüren parametreli metot çağrıldı");
        float ort = (float) (sayi1 + sayi2) / 2 ;
        return ort;
    }

    int rastgeleSayi() {
        System.out.println("Değer döndüren metot çağrıldı");
        Random rastgele = new Random();
        int sayi = rastgele.nextInt(20);
        return sayi;
    }

    void kisiSelamla(String isim) {
        Toast.makeText(this, "Merhaba " + isim, Toast.LENGTH_SHORT).show();
    }

    void selamla() {
        Toast.makeText(this, "Merhaba", Toast.LENGTH_SHORT).show();
    }

}