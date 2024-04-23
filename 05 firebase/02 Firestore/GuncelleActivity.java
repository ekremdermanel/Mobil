package com.example.okulhaber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class GuncelleActivity extends AppCompatActivity {

    FirebaseFirestore db;
    String id;
    EditText edtBaslik,edtAciklama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);
        edtBaslik=findViewById(R.id.edtBaslik);
        edtAciklama=findViewById(R.id.edtAciklama);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("haberler").document(id);


        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Haber haber = documentSnapshot.toObject(Haber.class);
                edtBaslik.setText(haber.baslik);
                edtAciklama.setText(haber.aciklama);
            }
        });
    }

    public void guncelle(View view) {
        /*
        Map<String, Object> data = new HashMap<>();
        data.put("baslik", edtBaslik.getText().toString());
        data.put("aciklama", edtAciklama.getText().toString());

        db.collection("haberler").document(id)
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(GuncelleActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                });
         */

        Haber haber = new Haber();
        haber.baslik=edtBaslik.getText().toString();
        haber.aciklama=edtAciklama.getText().toString();

        db.collection("haberler").document(id)
                .set(haber)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(GuncelleActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                });

        
    }
}