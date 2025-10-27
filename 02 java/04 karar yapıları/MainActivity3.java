package com.example.kararyapilari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView textView1;
    CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
    }

    public void onayla(View view) {
        String yazi ="";

        if(checkBox1.isChecked()) {
            yazi += checkBox1.getText().toString() + "\n";
        }

        if(checkBox2.isChecked()) {
            yazi += checkBox2.getText().toString() + "\n";
        }

        if(checkBox3.isChecked()) {
            yazi += checkBox3.getText().toString() + "\n";
        }

        if(yazi.equals("")) {
            textView1.setText("Seçim Yapılmadı");
        } else {
            textView1.setText(yazi);
        }

        CheckBox check = (CheckBox) view;
        System.out.println(check.getText().toString() + " " + check.isChecked());
    }
}