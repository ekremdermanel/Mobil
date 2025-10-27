package com.example.metotlar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText editText1,editText2, editText3;
    Button button1,button2,button3;
    TextView textView1;
    float sayi1,sayi2,sayi3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        textView1 = findViewById(R.id.textView1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ortalama();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enBuyuk();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enKucuk();
            }
        });
    }
    boolean sayilariAl() {
        try {
            sayi1= Float.parseFloat(editText1.getText().toString());
            sayi2= Float.parseFloat(editText2.getText().toString());
            sayi3= Float.parseFloat(editText2.getText().toString());
            return true;
        } catch (Exception e) {
            Toast.makeText(this, "Sayı alınamadı", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    void yazdir(float sonuc) {
        textView1.setText("Sonuç: " + sonuc);
    }

    void ortalama() {
        if (!sayilariAl()) {
            return;
        }
        float ort = (sayi1 + sayi2+ sayi3) / 3;
        yazdir(ort);
    }

    void enBuyuk() {
        if (!sayilariAl()) {
            return;
        }
        float eb;
        if(sayi1>=sayi2 && sayi1>=sayi3) {
            eb=sayi1;
        } else if(sayi2>=sayi1 && sayi2>=sayi3) {
            eb=sayi2;
        } else {
            eb=sayi3;
        }
        yazdir(eb);
    }

    void enKucuk() {
        if (!sayilariAl()) {
            return;
        }
        float ek;
        if(sayi1<=sayi2 && sayi1<=sayi3) {
            ek=sayi1;
        } else if(sayi2<=sayi1 && sayi2<=sayi3) {
            ek=sayi2;
        } else {
            ek=sayi3;
        }
        yazdir(ek);
    }


}