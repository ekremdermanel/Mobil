package com.example.hataayiklama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button1;
    TextView textView1;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Bilgi","Activity oluşturuldu");
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Bilgi","Düğmeye tıklandı");
                editText1 = findViewById(R.id.editText1);
                Log.i("Bilgi","Edit Text atandı");
                String s1 = editText1.getText().toString();
                Log.i("Bilgi","Edit Text içindeki yazı alındı");
                int sayi=0;
                Log.i("Bilgi","Sayı tanımlandı");
                try {
                    sayi = Integer.parseInt(s1);
                    Log.i("Bilgi","Yazı sayıya çevrildi");
                } catch (Exception e) {
                    Log.e("Hata","Sayıya çevirme hatası");
                    Log.e("Hata",e.toString());
                    sayi=0;
                } finally {
                    sayi = sayi + 2;
                    Log.i("Bilgi","sayıya 2 eklendi");
                }

                textView1 = findViewById(R.id.textView1);
                Log.i("Bilgi","Text View atandı");
                textView1.setText("Sayı : " + sayi);
                Log.i("Bilgi","Text View içerisine sayı yazıldı");
            }
        });

    }
}