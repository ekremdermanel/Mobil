package com.example.ornek1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hoşçakal", Toast.LENGTH_SHORT).show();
                textView1.setText("Hoşçakal Arkadaşım");
            }
        });
    }

    public void selamla(View view) {
        Toast.makeText(this, "Merhaba", Toast.LENGTH_SHORT).show();
        textView1.setText("Merhaba Arkadaşım");
    }
}