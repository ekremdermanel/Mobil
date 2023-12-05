package com.example.diziler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    TextView textView1;
    ArrayList<String> sehirler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1= findViewById(R.id.editText1);
        textView1=findViewById(R.id.textView1);
        sehirler = new ArrayList<>();
    }

    public void ekle(View view) {
        String sehir = editText1.getText().toString().trim();
        if(!sehirler.contains(sehir)) {
            sehirler.add(sehir);
            textView1.setText(textView1.getText().toString() + "\n" + sehir);
        } else {
            Toast.makeText(this, sehir + " zaten var", Toast.LENGTH_SHORT).show();
        }
        editText1.setText("");
    }

    public void sil(View view) {
        String sehir = editText1.getText().toString().trim();
        int siraNo = sehirler.indexOf(sehir);
        if(siraNo!=-1) {
            sehirler.remove(siraNo);
            textView1.setText(textView1.getText().toString().replace("\n" + sehir,""));
        } else {
            Toast.makeText(this, sehir + " listede yok", Toast.LENGTH_SHORT).show();
        }
        editText1.setText("");
    }

    public void temizle(View view) {
        sehirler.clear();
        textView1.setText("");
    }

}