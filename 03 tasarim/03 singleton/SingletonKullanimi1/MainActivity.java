package com.example.singletonkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        String adSoyad = Singleton.getInstance().getAdSoyad();
        int yas = Singleton.getInstance().getYas();

        if(adSoyad!=null) {
            editText1.setText(adSoyad);
            editText2.setText("" + yas);
        }

    }

    public void kaydet(View view) {
	String adSoyad = editText1.getText().toString();
        int yas = Integer.parseInt(editText2.getText().toString());
        if(adSoyad.equals("")) {
            Toast.makeText(this, "Ad soyad giriniz", Toast.LENGTH_SHORT).show();
            return;
        }
        Singleton.getInstance().setAdSoyad(adSoyad);
        Singleton.getInstance().setYas(yas);
        Toast.makeText(this, "Kayıt yapıldı", Toast.LENGTH_SHORT).show();

        Singleton.getInstance().setAdSoyad(adSoyad);
        Singleton.getInstance().setYas(yas);
        Toast.makeText(this, "Kayıt yapıldı", Toast.LENGTH_SHORT).show();
    }

    public void profil(View view) {
        Intent intent = new Intent(this,ProfilActivity.class);
        startActivity(intent);
    }
}