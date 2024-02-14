package com.example.recyclerviewornek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        TextView textView1,textView2,textView3,textView4;
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);

        Intent intent = getIntent();
        Urun urun = (Urun) intent.getSerializableExtra("urun");
        textView1.setText("Ürün Kodu: " + urun.urunKodu);
        textView2.setText("Ürün Adı: " + urun.urunAdi);
        textView3.setText("Fiyat: " + urun.fiyat + " TL");
        textView4.setText("Stok: " + urun.stok);
    }
}