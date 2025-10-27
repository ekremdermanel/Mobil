package com.example.metotlar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selamla();
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selamla();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gonderilenIsim = isimGonder();
                Toast.makeText(MainActivity.this, "Merhaba " + gonderilenIsim, Toast.LENGTH_SHORT).show();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ortalama(5,2);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float gonderilenOrtalama = ortalamaGonder(4.6f, 3.66f);
                Toast.makeText(MainActivity.this, "Toplam: " + gonderilenOrtalama, Toast.LENGTH_SHORT).show();
            }
        });
    }

    void selamla() {
        Toast.makeText(this, "Merhaba", Toast.LENGTH_SHORT).show();
    }

    String isimGonder() {
        String isim = "Ahmet";
        return isim;
    }

    void ortalama(int a, int b) {
        float ort = (float) (a + b) /2;
        Toast.makeText(this, "Toplam: " + ort, Toast.LENGTH_SHORT).show();
    }

    float ortalamaGonder(int a, int b) {
        float sayilarinOrtalamasi = (float)(a + b)/2;
        return sayilarinOrtalamasi;
    }

    int ortalamaGonder(int x, int y, int z) {
        int sayilarinOrtalamasi = (x + y + z)/2;
        return sayilarinOrtalamasi;
    }

    float ortalamaGonder(float a, float b) {
        float sayilarinOrtalamasi = (a + b)/2;
        return sayilarinOrtalamasi;
    }

    float ortalamaGonder(float a, float b, float c) {
        float sayilarinOrtalamasi = (a + b + c)/3;
        return sayilarinOrtalamasi;
    }
}