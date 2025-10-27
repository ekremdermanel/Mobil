package com.example.mesajlar;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        ListView listView=findViewById(R.id.listView);

        adapter = new UrunAdapter(this,arrayList);
        listView.setAdapter(adapter);
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