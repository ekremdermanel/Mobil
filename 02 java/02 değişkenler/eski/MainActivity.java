package com.example.degiskenler2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,button5,button6;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        textView1 = findViewById(R.id.textView1);
        textView1.setText("Merhaba");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sayi1 = 213;
                long sayi2 = 9387458934L;
                textView1.setText("Değişken1: " + sayi1 + "\nDeğişken2: " + sayi2);
                System.out.println("Değişken1: " + sayi1);
                System.out.println("Değişken2: " + sayi2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char karakter = '#' + 5;
                int ascii = (int) karakter;
                textView1.setText("Değişken1: " + karakter + "\nDeğişken2: " + ascii);
                System.out.println("Karakter: " + karakter);
                System.out.println("ASCII kodu: " + ascii);

                char karakter2 = (char) 240;
                System.out.println(karakter2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float sayi1 = 23.58f / 3.89f;
                double sayi2 = 23.58d / 3.89d;
                textView1.setText("Değişken1: " + sayi1 + "\nDeğişken2: " + sayi2);
                System.out.println("Değişken1: " + sayi1);
                System.out.println("Değişken2: " + sayi2);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean deger1 = false;
                boolean deger2 = (5>4 && 3!=1);
                textView1.setText("Değişken1: " + deger1 + "\nDeğişken2: " + deger2);
                System.out.println("Değişken1: " + deger1);
                System.out.println("Değişken2: " + deger2);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isim = "Mehmet";
                char karakter = isim.charAt(2);
                textView1.setText("İsim: " + isim + "\nKarakter: " + karakter);
                System.out.println("İsim: " + isim);
                System.out.println("Karakter: " + karakter);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final float PI_SAYISI = 3.14f;
                int yaricap = 5;
                float cevre = 2 * PI_SAYISI * yaricap;
                // float alan = PI_SAYISI * yaricap * yaricap;
                float alan = PI_SAYISI * (float) Math.pow(yaricap,2);
                textView1.setText("Çevre: " + cevre + "\nAlan: " + alan);
                System.out.println("Çevre: " + cevre);
                System.out.println("Alan: " + alan);
            }
        });


    }
}