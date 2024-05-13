package com.example.telefonrehberimobil;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EkleActivity extends AppCompatActivity {

    EditText edtAdSoyad,edtTelefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        edtAdSoyad = findViewById(R.id.edtAdSoyad);
        edtTelefon = findViewById(R.id.edtTelefon);
    }

    public void ekle(View view) {
        String adSoyad = edtAdSoyad.getText().toString();
        String telefon = edtTelefon.getText().toString();

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("adSoyad", adSoyad);
            jsonObject.put("telefon", telefon);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String url ="http://telefonrehberi.somee.com/api/Kisi/Ekle" ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
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
                headers.put("Content-Type", "application/json");
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