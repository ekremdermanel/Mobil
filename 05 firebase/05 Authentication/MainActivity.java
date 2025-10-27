package com.example.kullanicilar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    TextView txtBilgi;
    Button btnGiris, btnCikis;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBilgi = findViewById(R.id.txtBilgi);
        btnGiris = findViewById(R.id.btnGiris);
        btnCikis = findViewById(R.id.btnCikis);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user==null) {
            txtBilgi.setText("Giriş Yapılmadı");
            btnGiris.setVisibility(View.VISIBLE);
            btnCikis.setVisibility(View.GONE);
        } else {
            txtBilgi.setText("Merhaba " + user.getDisplayName());
            btnGiris.setVisibility(View.GONE);
            btnCikis.setVisibility(View.VISIBLE);
        }
    }

    public void giris(View view) {
        Intent intent = new Intent(this,GirisActivity.class);
        startActivity(intent);
    }

    public void cikis(View view) {
        mAuth.signOut();
        onResume();
    }
}