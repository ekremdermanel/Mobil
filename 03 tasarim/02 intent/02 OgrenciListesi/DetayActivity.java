package com.example.ogrencilistesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class DetayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        ArrayList<String> isimler = new ArrayList<>(
                Arrays.asList("Ahmet", "Ayşe", "Sibel", "Aslı", "Mehmet")
        );

        ArrayList<Integer> numaralar = new ArrayList<>(
                Arrays.asList(100, 150, 200, 250, 300)
        );

        ArrayList<String> cinsiyetler = new ArrayList<>(
                Arrays.asList("erkek", "kız", "kız", "kız", "erkek")
        );

        Intent intent = getIntent();
        int indexNo = intent.getIntExtra("indexNo",0);

        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        ImageView imageView = findViewById(R.id.imageView);

        textView1.setText("İsim: " + isimler.get(indexNo));
        textView2.setText("Numara: " + numaralar.get(indexNo));
        if (cinsiyetler.get(indexNo).equals("erkek")) {
            imageView.setImageResource(R.drawable.icon_erkek);
        } else {
            imageView.setImageResource(R.drawable.icon_kiz);
        }

    }

    public void geriDon(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}