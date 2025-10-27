package com.example.yapilacaklarlistesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = this.openOrCreateDatabase("YapilacaklarListesiDB", MODE_PRIVATE, null);

        String tablo = "CREATE TABLE IF NOT EXISTS yapilacaklar(id INTEGER PRIMARY KEY, baslik VARCHAR, aciklama TEXT)";
        database.execSQL(tablo);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<Yapilacak> arrayList = new ArrayList<>();
        String sorgu = "SELECT id,baslik FROM yapilacaklar";
        Cursor cursor = database.rawQuery(sorgu,null);
        while(cursor.moveToNext()) {
            Yapilacak yapilacak = new Yapilacak();
            yapilacak.id = cursor.getInt(0);
            yapilacak.baslik = cursor.getString(1);
            arrayList.add(yapilacak);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        YapilacakAdapter adapter = new YapilacakAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
    }

    public void ekle(View view) {
        Intent intent = new Intent(this,EkleActivity.class);
        startActivity(intent);
    }
}