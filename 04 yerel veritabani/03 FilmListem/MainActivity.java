package com.example.filmlistem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = this.openOrCreateDatabase("FilmListemDB", MODE_PRIVATE, null);

        String tablo = "CREATE TABLE IF NOT EXISTS filmler(id INTEGER PRIMARY KEY, filmAdi VARCHAR, puan REAL, fav INTEGER)";
        database.execSQL(tablo);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<Film> arrayList = new ArrayList<>();
        String sorgu = "SELECT * FROM filmler";
        Cursor cursor = database.rawQuery(sorgu,null);
        while(cursor.moveToNext()) {
            Film film = new Film();
            film.id = cursor.getInt(0);
            film.filmAdi = cursor.getString(1);
            film.puan = cursor.getDouble(2);
            film.fav = cursor.getInt(3);
            arrayList.add(film);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FilmAdapter adapter = new FilmAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
    }


    public void ekle(View view) {
        Intent intent = new Intent(this,EkleActivity.class);
        startActivity(intent);
    }
}