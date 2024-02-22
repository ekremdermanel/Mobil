package com.example.yapilacaklarlistesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EkleActivity extends AppCompatActivity {

    EditText editText1,editText2;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        database = this.openOrCreateDatabase("YapilacaklarListesiDB", MODE_PRIVATE, null);
    }

    public void ekle(View view) {
        String baslik = editText1.getText().toString();
        String aciklama = editText2.getText().toString();

        String sorgu="INSERT INTO yapilacaklar(baslik,aciklama) VALUES(?,?)";
        SQLiteStatement durumlar=database.compileStatement(sorgu);
        durumlar.bindString(1,baslik);
        durumlar.bindString(2, aciklama);
        durumlar.execute();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}