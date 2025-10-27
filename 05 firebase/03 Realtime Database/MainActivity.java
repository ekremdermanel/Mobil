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

    TextView txtBaslik;
    EditText edtBaslik, edtGonderen, edtIcerik;
    ListView listView;
    ArrayList<Mesaj> arrayList;
    MesajAdapter adapter;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBaslik=findViewById(R.id.txtBaslik);
        edtBaslik=findViewById(R.id.edtBaslik);
        edtGonderen=findViewById(R.id.edtGonderen);
        edtIcerik=findViewById(R.id.edtIcerik);
        listView=findViewById(R.id.listView);

        arrayList = new ArrayList<>();

        adapter = new MesajAdapter(this,arrayList);
        listView.setAdapter(adapter);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("baslik").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    txtBaslik.setText(task.getResult().getValue().toString());
                    edtBaslik.setText(task.getResult().getValue().toString());
                }
                else {

                }
            }
        });

        /*
        mDatabase.child("mesajlar").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    for (DataSnapshot snapshot : task.getResult().getChildren()) {
                        Mesaj mesaj = snapshot.getValue(Mesaj.class);
                        arrayList.add(mesaj);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.d(TAG, task.getException().getMessage());
                }
            }
        });*/

        mDatabase.child("baslik").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                txtBaslik.setText(snapshot.getValue().toString());
                edtBaslik.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mDatabase.child("mesajlar").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Mesaj mesaj = snapshot.getValue(Mesaj.class);
                mesaj.id = snapshot.getKey();
                arrayList.add(mesaj);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                for(int i = 0; i < arrayList.size(); i++)
                {
                    if(arrayList.get(i).id.equals(snapshot.getKey())){
                        arrayList.remove(i);
                        break;
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void degistir(View view) {
        String baslik = edtBaslik.getText().toString();
        mDatabase.child("baslik").setValue(baslik)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Başlık Değişti", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void gonder(View view) {
        String gonderen = edtGonderen.getText().toString();
        String icerik = edtIcerik.getText().toString();

        Mesaj mesaj = new Mesaj();
        mesaj.gonderen=gonderen;
        mesaj.icerik = icerik;

        //Map<String, Object> data = new HashMap<>();
        //data.put("gonderen", gonderen);
        //data.put("icerik", icerik);

        String mesajId = mDatabase.child("mesajlar").push().getKey();
        mDatabase.child("mesajlar").child(mesajId).setValue(mesaj)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Mesaj Gönderildi", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}