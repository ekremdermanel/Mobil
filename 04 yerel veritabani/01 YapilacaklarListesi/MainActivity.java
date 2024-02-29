package com.example.yapilacaklarlistesi;

import androidx.appcompat.app.AppCompatActivity;

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

        ListView listView = findViewById(R.id.listView);

        ArrayList<String> arrayList = new ArrayList<>();
        String sorgu = "SELECT * FROM yapilacaklar";
        Cursor cursor = database.rawQuery(sorgu,null);
        int kolonNo = cursor.getColumnIndex("baslik");
        while(cursor.moveToNext()) {
            arrayList.add(cursor.getString(kolonNo));
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String baslik = arrayList.get(i);
                String sorgu = "DELETE FROM yapilacaklar WHERE baslik=?";
                SQLiteStatement durumlar=database.compileStatement(sorgu);
                durumlar.bindString(1,baslik);
                durumlar.execute();
                arrayList.remove(i);
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void ekle(View view) {
        Intent intent = new Intent(this,EkleActivity.class);
        startActivity(intent);
    }
}