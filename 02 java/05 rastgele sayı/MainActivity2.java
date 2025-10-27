package com.example.rastgelesayi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button button1,button2;
    EditText editText1;
    TextView textView1;
    int rastgeleSayi, tahminSayisi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editText1);
        textView1 = findViewById(R.id.textView1);
        button2.setVisibility(View.GONE);
        Random rastgele = new Random();
        rastgeleSayi = rastgele.nextInt(90) + 10;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int girilenSayi = Integer.parseInt(editText1.getText().toString());
                editText1.setText("");
                tahminSayisi++;
                if(girilenSayi < rastgeleSayi) {
                    textView1.setText("Daha büyük sayı gir");
                } else if(girilenSayi > rastgeleSayi) {
                    textView1.setText("Daha küçük sayı gir");
                } else {
                    textView1.setText("Tebrikler " + tahminSayisi + " tahminde bildin");
                    button1.setEnabled(false);
                    button2.setVisibility(View.VISIBLE);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rastgele = new Random();
                rastgeleSayi = rastgele.nextInt(90) + 10;
                tahminSayisi=0;
                button1.setEnabled(true);
                button2.setVisibility(View.GONE);
                textView1.setText("Tahmini Gir");
            }
        });
    }
}