package com.example.degiskenler2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button button1,button2;
    EditText editText1, editText2;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView1 = findViewById(R.id.textView1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(editText1.getText().toString());
                int y = Integer.parseInt(editText2.getText().toString());
                int toplam = x + y;
                int fark = x - y;
                int carpim = x * y;
                float bolme = (float) x / (float) y;
                int mod = x % y;
                x++; // x=x+1 x+=1
                y--;
                textView1.setText("Toplam: " + toplam +
                        "\nFark: " + fark +
                        "\nÇarpım: " + carpim +
                        "\nBölme: " + bolme +
                        "\nMod Alma: " + mod +
                        "\nArtırma: " + x +
                        "\nAzaltma: " + y
                );
                System.out.println("Toplam: " + toplam);
                System.out.println("Fark: " + fark);
                System.out.println("Çarpım: " + carpim);
                System.out.println("Bölme: " + bolme);
                System.out.println("Mod Alma: " + mod);
                System.out.println("Artırma: " + x);
                System.out.println("Azaltma: " + y);
            }
        });
        
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(editText1.getText().toString());
                textView1.setText("x = " + x);
                System.out.println("x = " + x);
                x += 3;
                textView1.setText(textView1.getText().toString() + "\n" + "x += 3 : " + x);
                System.out.println("x += 3 : " + x);
                x -= 2;
                textView1.setText(textView1.getText().toString() + "\n" + "x -= 2 : " + x);
                System.out.println("x -= 2 : " + x);
                x *= 2;
                textView1.setText(textView1.getText().toString() + "\n" + "x *= 2 : " + x);
                System.out.println("x *= 2 : " + x);
                x /= 4;
                textView1.setText(textView1.getText().toString() + "\n" + "x /= 4 : " + x);
                System.out.println("x /= 4 : " + x);
                x %= 2;
                textView1.setText(textView1.getText().toString() + "\n" + "x %= 2 : " + x);
                System.out.println("x %= 2 : " + x);
            }
        });
        
    }
}