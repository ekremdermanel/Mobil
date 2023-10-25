package com.example.kararyapilari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Switch switch1,switch2,switch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        switch2.setVisibility(View.GONE);
        switch3.setVisibility(View.GONE);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switch1.isChecked()) {
                    switch2.setVisibility(View.VISIBLE);
                    switch3.setVisibility(View.VISIBLE);
                } else {
                    switch2.setVisibility(View.GONE);
                    switch3.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onayla(View view) {
        if(switch2.isChecked() && switch3.isChecked()) {
            Toast.makeText(this, "Konum al ve gönder açık", Toast.LENGTH_SHORT).show();
        } else if(switch2.isChecked() && !switch3.isChecked()) {
            Toast.makeText(this, "Konum al açık, gönder kapalı", Toast.LENGTH_SHORT).show();
        } else if(!switch2.isChecked() && switch3.isChecked()) {
            Toast.makeText(this, "Konum al kapalı, gönder açık", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Konum al ve gönder kapalı", Toast.LENGTH_SHORT).show();
        }
    }
}