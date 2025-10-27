package com.example.recyclerviewornek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    ArrayList<Urun> urunler = new ArrayList<>(
            Arrays.asList(
                    new Urun("g234","Masa",100,10),
                    new Urun("h343","Sandalye",50,5),
                    new Urun("z354","Dolap",130,50),
                    new Urun("k435","Sehpa",80,20)
            )
    );

    UrunAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UrunAdapter(this,urunler);
        recyclerView1.setAdapter(adapter);
    }

    public void sil(View view) {
        urunler.remove(urunler.size()-1);
        adapter.notifyDataSetChanged();
    }

    public void guncelle(View view) {
        for (Urun urun: urunler) {
            urun.fiyat *= 1.1;
        }
        adapter.notifyDataSetChanged();
    }

    public void ekle(View view) {
        String[] ornekUrunler = { "Televizyon","Buzdolabı","Çamaşır Makinesi","Bulaşık Makinesi","Düdüklü Tencere" };
        Random random = new Random();
        Urun urun = new Urun();
        urun.urunAdi = ornekUrunler[random.nextInt(ornekUrunler.length)];
        urun.stok = random.nextInt(20);

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        urun.fiyat = Double.parseDouble(decimalFormat.format(random.nextDouble()*200 + 50));

        UUID uuid = UUID.randomUUID();
        urun.urunKodu = uuid.toString();

        urunler.add(urun);
        adapter.notifyDataSetChanged();
    }
}