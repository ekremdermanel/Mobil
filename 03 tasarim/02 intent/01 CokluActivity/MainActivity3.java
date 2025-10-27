package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String gelenIsim = intent.getStringExtra("isim");
        int gelenNumara = intent.getIntExtra("numara",0);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Merhaba "  + gelenNumara + " numaralı " + gelenIsim);
    }

    public void gonder(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}