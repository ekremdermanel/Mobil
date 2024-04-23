package com.example.fotografarsivi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class UploadActivity extends AppCompatActivity {

    ImageView imgFoto;
    Uri imageUri;
    Button btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        imgFoto=findViewById(R.id.imgFoto);
        imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityIntent.launch(intent);
            }
        });

        btnUpload=findViewById(R.id.btnUpload);
        btnUpload.setEnabled(false);
    }

    ActivityResultLauncher<Intent> startActivityIntent = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK) {
                    imageUri = result.getData().getData();
                    imgFoto.setImageURI(imageUri);
                    btnUpload.setEnabled(true);
                }
            }
        });

    public void yukle(View view) {
        FirebaseStorage storage = FirebaseStorage.getInstance();

        String fotoAdi = UUID.randomUUID().toString();
        StorageReference storageReference = storage.getReference();
        StorageReference fotoRef = storageReference.child("images/"+fotoAdi);
        fotoRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Snackbar.make(view, "Yüklendi", Snackbar.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UploadActivity.this, "Hata", Toast.LENGTH_SHORT).show();
                    }
                });

        imageUri = null;
        imgFoto.setImageResource(R.drawable.no_image);
        btnUpload.setEnabled(false);
    }


}