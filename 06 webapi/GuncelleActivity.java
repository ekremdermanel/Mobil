package com.example.telefonrehberimobil;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GuncelleActivity extends AppCompatActivity {

    EditText edtAdSoyad,edtTelefon;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        edtAdSoyad = findViewById(R.id.edtAdSoyad);
        edtTelefon = findViewById(R.id.edtTelefon);

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        String url ="http://telefonrehberi.somee.com/api/Kisi/Detay/" + id;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Kisi kisi = new Kisi();
                    kisi.adSoyad = response.getString("adSoyad");
                    kisi.telefon = response.getString("telefon");
                    edtAdSoyad.setText(kisi.adSoyad);
                    edtTelefon.setText(kisi.telefon);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e(TAG, "onResponse: " + e.getMessage() );
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }

    public void guncelle(View view) {
        String adSoyad = edtAdSoyad.getText().toString();
        String telefon = edtTelefon.getText().toString();

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id",id);
            jsonObject.put("adSoyad", adSoyad);
            jsonObject.put("telefon", telefon);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String url ="http://telefonrehberi.somee.com/api/Kisi/Guncelle" ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "onResponse: " + response.toString());

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e(TAG, "onErrorResponse: " + error.getMessage() );
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }

    public void iptal(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}