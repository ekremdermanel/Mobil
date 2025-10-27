package com.example.uygulama2526;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void topla(View view) {
        EditText editSayi1, editSayi2;
        TextView textSonuc;

        editSayi1 = findViewById(R.id.editSayi1);
        editSayi2 = findViewById(R.id.editSayi2);
        textSonuc = findViewById(R.id.textSonuc);

        int sayi1 = Integer.parseInt(editSayi1.getText().toString());
        int sayi2 = Integer.parseInt(editSayi2.getText().toString());

        int sonuc = sayi1 + sayi2;

        textSonuc.setText("Toplam: " + sonuc);
    }
}