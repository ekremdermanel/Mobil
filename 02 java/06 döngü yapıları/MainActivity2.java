package com.example.donguyapilari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1 = findViewById(R.id.textView1);
    }

    public void rastgele10Sayi(View view) {
        textView1.setText("");
        Random rastgele = new Random();
        int sayi;
        int i=0;
        while (i<10) {
            sayi = rastgele.nextInt(50);
            textView1.setText(textView1.getText().toString() + "\n" + sayi);
            i++;
        }
    }

    public void rastgele5eKadar(View view) {
        textView1.setText("");
        Random rastgele = new Random();
        int sayi;
        do {
            sayi = rastgele.nextInt(50);
            textView1.setText(textView1.getText().toString() + "\n" + sayi);
        } while (sayi != 5);
    }
}