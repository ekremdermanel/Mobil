package com.example.ayarlarisakla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText edtKullanici;
    RadioButton rbAcik, rbKoyu;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtKullanici = findViewById(R.id.edtKullanici);
        rbAcik = findViewById(R.id.rbAcik);
        rbKoyu = findViewById(R.id.rbKoyu);

        sharedPreferences=this.getPreferences(Context.MODE_PRIVATE);

        String gelenKullaniciAdi=sharedPreferences.getString("kullaniciAdi","");
        if(!gelenKullaniciAdi.isEmpty()){
            edtKullanici.setText(gelenKullaniciAdi);
        }

        int gelenTema = sharedPreferences.getInt("tema",AppCompatDelegate.MODE_NIGHT_NO);
        AppCompatDelegate.setDefaultNightMode(gelenTema);
        if(gelenTema==AppCompatDelegate.MODE_NIGHT_NO)
            rbAcik.setChecked(true);
        else
            rbKoyu.setChecked(true);
    }

    public void kaydet(View view) {
        sharedPreferences=this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        String kullaniciAdi = edtKullanici.getText().toString();
        editor.putString("kullaniciAdi",kullaniciAdi);

        if(rbAcik.isChecked()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            editor.putInt("tema",AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            editor.putInt("tema",AppCompatDelegate.MODE_NIGHT_YES);
        }

        editor.apply();
        Toast.makeText(this, "Kaydedildi", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        sharedPreferences=null;
        super.onDestroy();
    }
}