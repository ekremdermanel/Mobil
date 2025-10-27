package com.example.diziler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    EditText editText1;
    ListView listView1;
    ArrayList<String> sehirler;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText1= findViewById(R.id.editText1);
        listView1=findViewById(R.id.listView1);
        sehirler = new ArrayList<>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,sehirler);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity2.this, sehirler.get(i) + " tıklandı", Toast.LENGTH_SHORT).show();
            }
        });

        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                sehirler.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public void ekle(View view) {
        String sehir = editText1.getText().toString().trim();
        if(!sehirler.contains(sehir)) {
            sehirler.add(sehir);
            adapter.notifyDataSetChanged();
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
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, sehir + " listede yok", Toast.LENGTH_SHORT).show();
        }
        editText1.setText("");
    }

    public void temizle(View view) {
        sehirler.clear();
        adapter.notifyDataSetChanged();
    }
}