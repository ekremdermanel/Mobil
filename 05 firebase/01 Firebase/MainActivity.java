package com.example.okulhaber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    HaberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Haber> arrayList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HaberAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);

        Haber haber;

        haber = new Haber();
        haber.baslik="Açılış Yapıldı";
        haber.aciklama="Keklik Cafe açıldı";
        arrayList.add(haber);

        haber = new Haber();
        haber.baslik="Pesiad Yarışması Tamamandı";
        haber.aciklama="Yine bildiğiniz gibi";
        arrayList.add(haber);

        adapter.notifyDataSetChanged();

    }

    public void ekle(View view) {
        Intent intent = new Intent(this,EkleActivity.class);
        startActivity(intent);
    }
}