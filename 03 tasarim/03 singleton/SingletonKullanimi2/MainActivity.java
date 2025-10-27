package com.example.singletonkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    RadioButton radioButton1,radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);

        Ogrenci ogrenci = Singleton.getInstance().getOgrenci();
        if(ogrenci.adSoyad!=null) {
            editText1.setText(ogrenci.adSoyad);
            editText2.setText(""+ogrenci.yas);
            if(ogrenci.cinsiyet.equals("erkek")) {
                radioButton1.setChecked(true);
            } else {
                radioButton2.setChecked(true);
            }
        }
    }

    public void kaydet(View view) {
        Ogrenci ogrenci = new Ogrenci();
        ogrenci.adSoyad = editText1.getText().toString();
        ogrenci.yas = Integer.parseInt(editText2.getText().toString());
        ogrenci.cinsiyet = radioButton1.isChecked() ? "erkek" : "kız";

        /*
        if(radioButton1.isChecked()) {
            ogrenci.cinsiyet = "erkek";
        } else {
            ogrenci.cinsiyet = "kız";
        }
        */

        Singleton.getInstance().setOgrenci(ogrenci);
        Toast.makeText(this, "Kayıt yapıldı", Toast.LENGTH_SHORT).show();
    }

    public void profil(View view) {
        Intent intent = new Intent(this,ProfilActivity.class);
        startActivity(intent);
    }
}