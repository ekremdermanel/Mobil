package com.example.donguyapilari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
    }

    public void tumSayilar(View view) {
        textView1.setText("");
        for (int i = 1; i <= 20 ; i++) {
            System.out.println(i);
            textView1.setText(textView1.getText().toString() + "\n" + i);
        }
    }

    public void tekSayilar(View view) {
        textView1.setText("");
        for (int i = 1; i <= 20 ; i+=2) {
            System.out.println(i);
            textView1.setText(textView1.getText().toString() + "\n" + i);
        }
    }

    public void ciftSayilar(View view) {
        textView1.setText("");
        for (int i = 2; i <= 20 ; i+=2) {
            System.out.println(i);
            textView1.setText(textView1.getText().toString() + "\n" + i);
        }
    }
}