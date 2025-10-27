package com.example.kullanicigiris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kullanicigiris.databinding.ActivityMain2Binding;
import com.example.kullanicigiris.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        String kullaniciAdi = intent.getStringExtra("kullaniciAdi");
        binding.textView1.setText("Hoşgeldin " + kullaniciAdi);
    }
}