package com.example.yapilacaklarlistesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {

    SQLiteDatabase database;
    int id;
    TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        if(id==0) {
            return;
        }

        database = this.openOrCreateDatabase("YapilacaklarListesiDB", MODE_PRIVATE, null);
        String sorgu = "SELECT * FROM yapilacaklar WHERE id=?";
        Cursor cursor = database.rawQuery(sorgu,new String[]{String.valueOf(id)});
        Yapilacak yapilacak = new Yapilacak();
        while(cursor.moveToNext()) {
            yapilacak.id = cursor.getInt(0);
            yapilacak.baslik = cursor.getString(1);
            yapilacak.aciklama=cursor.getString(2);
        }

        textView1.setText(yapilacak.baslik);
        textView2.setText(yapilacak.aciklama);
    }

    public void sil(View view) {
        String sorgu = "DELETE FROM yapilacaklar WHERE id=?";
        SQLiteStatement durumlar=database.compileStatement(sorgu);
        durumlar.bindLong(1,id);
        durumlar.execute();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void guncelle(View view) {
        Intent intent = new Intent(this,GuncelleActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}