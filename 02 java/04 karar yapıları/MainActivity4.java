package com.example.kararyapilari;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class MainActivity4 extends AppCompatActivity {

    String renk = "";
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        layout=findViewById(R.id.layout);
        layout.setBackgroundColor(Color.WHITE);
    }

    public void secimYap(View view) {
        RadioButton radio = (RadioButton) view;
        renk = radio.getText().toString();
    }

    public void onayla(View view) {
        switch (renk) {
            case "Kırmızı":
                layout.setBackgroundColor(Color.RED);
                break;
            case "Sarı":
                layout.setBackgroundColor(Color.YELLOW);
                break;
            case "Mavi":
                layout.setBackgroundColor(Color.BLUE);
                break;
            default:
                layout.setBackgroundColor(Color.WHITE);
                break;
        }
    }
}