package com.example.okulhaber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EkleActivity extends AppCompatActivity {

    FirebaseFirestore db;
    EditText edtBaslik,edtAciklama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);
        edtBaslik=findViewById(R.id.edtBaslik);
        edtAciklama=findViewById(R.id.edtAciklama);
        db = FirebaseFirestore.getInstance();
    }

    public void ekle(View view) {
        /*
        Map<String, Object> data = new HashMap<>();
        data.put("baslik", edtBaslik.getText().toString());
        data.put("aciklama", edtAciklama.getText().toString());
        
        db.collection("haberler")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EkleActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                });
         */

        Haber haber = new Haber();
        haber.baslik=edtBaslik.getText().toString();
        haber.aciklama=edtAciklama.getText().toString();

        db.collection("haberler")
                .add(haber)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EkleActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                });

        
    }
}