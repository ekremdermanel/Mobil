package com.example.yapilacaklarlistesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GuncelleActivity extends AppCompatActivity {

    int id;
    EditText editText1,editText2;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        database = this.openOrCreateDatabase("YapilacaklarListesiDB", MODE_PRIVATE, null);

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

        editText1.setText(yapilacak.baslik);
        editText2.setText(yapilacak.aciklama);
    }

    public void guncelle(View view) {
        String baslik = editText1.getText().toString();
        String aciklama = editText2.getText().toString();

        String sorgu="UPDATE yapilacaklar SET baslik=? , aciklama=? WHERE id=?";
        SQLiteStatement durumlar=database.compileStatement(sorgu);
        durumlar.bindString(1,baslik);
        durumlar.bindString(2, aciklama);
        durumlar.bindLong(3, id);
        durumlar.execute();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}