package com.example.kullanicigiris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.kullanicigiris.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.editText1.setText("");
        binding.editText2.setText("");
        binding.textView1.setText("");
    }

    public void giris(View view) {
        String kullaniciAdi = binding.editText1.getText().toString();
        String sifre = binding.editText2.getText().toString();

        if(kullaniciAdi.equals("admin") && sifre.equals("123")) {
            Intent intent = new Intent(this,MainActivity2.class);
            intent.putExtra("kullaniciAdi",kullaniciAdi);
            startActivity(intent);
        } else {
            binding.textView1.setText("Hata");
        }
    }
}