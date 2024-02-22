package com.example.yapilacaklarlistesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = this.openOrCreateDatabase("YapilacaklarListesiDB",MODE_PRIVATE,null);

        String tablo = "CREATE TABLE IF NOT EXISTS yapilacaklar(id INTEGER PRIMARY KEY, baslik VARCHAR, aciklama TEXT)";
        database.execSQL(tablo);
    }

    public void ekle(View view) {
        Intent intent = new Intent(this,EkleActivity.class);
        startActivity(intent);
    }
}