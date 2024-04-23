package com.example.okulhaber;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetayActivity extends AppCompatActivity {

    FirebaseFirestore db;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        TextView txtBaslik=findViewById(R.id.txtBaslik);
        TextView txtAciklama=findViewById(R.id.txtAciklama);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("haberler").document(id);

        /*
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    txtBaslik.setText(document.getData().get("baslik").toString());
                    txtAciklama.setText(document.getData().get("aciklama").toString());
                } else {
                    Toast.makeText(DetayActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                }
            }
        });
        */

        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Haber haber = documentSnapshot.toObject(Haber.class);
                txtBaslik.setText(haber.baslik);
                txtAciklama.setText(haber.aciklama);
            }
        });

    }

    public void guncelle(View view) {
        Intent intent = new Intent(getApplicationContext(),GuncelleActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    public void sil(View view) {
        db.collection("haberler").document(id)
                .delete()
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
                        Toast.makeText(DetayActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}