package com.example.ornek1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    Button button1;
    TextView textView1;
    ConstraintLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button1 = findViewById(R.id.button1);
        textView1 = findViewById(R.id.textView1);
        layout1 = findViewById(R.id.layout1);
        button1.setText("Tamam");
        textView1.setText("Yazı Alanı");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("Butona tıklandı");
                textView1.setBackgroundColor(Color.parseColor("#ff0000"));
                textView1.setTextColor(Color.parseColor("#ffff00"));
                layout1.setBackgroundColor(Color.parseColor("#333333"));
            }
        });

        button1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView1.setText("Butona uzun basıldı");
                textView1.setBackgroundColor(Color.parseColor("#00ff00"));
                textView1.setTextColor(Color.parseColor("#ffffff"));
                layout1.setBackgroundColor(Color.parseColor("#aaaaaa"));
                return true;
            }
        });

    }
}