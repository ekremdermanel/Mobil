package com.example.fragmentkullanimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gecis1(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        OrnekFragment1 fragment = new OrnekFragment1();
        fragmentTransaction.replace(R.id.frameLayout1,fragment);
        fragmentTransaction.commit();
    }

    public void gecis2(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        OrnekFragment2 fragment = new OrnekFragment2();
        fragmentTransaction.replace(R.id.frameLayout1,fragment);
        fragmentTransaction.commit();
    }
}