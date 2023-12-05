package com.example.ogrencilistesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        ArrayList<String> isimler = new ArrayList<>(
                Arrays.asList("Ahmet", "Ayşe", "Sibel", "Aslı", "Mehmet")
        );
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, isimler);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),DetayActivity.class);
                intent.putExtra("indexNo", i);
                startActivity(intent);
            }
        });
    }
}