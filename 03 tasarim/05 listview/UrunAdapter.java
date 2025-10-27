package com.example.mesajlar;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UrunAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Mesaj> arrayList;

    public UrunAdapter(Context context, ArrayList<Mesaj> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.urun_card, viewGroup, false);
        }

        Urun urun = (Urun) getItem(i);

        TextView textView1 = view.findViewById(R.id.textView1);
        TextView textView2 = view.findViewById(R.id.textView2);
        CardView cardView1 = view.findViewById(R.id.cardView1);

        textView1.setText(urun.urunAdi);
        textView2.setText(urun.fiyat + " TL");

        cardView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(context,DetayActivity.class);
                intent.putExtra("urun",urun);
                context.startActivity(intent);
                return true;
            }
        });



        return view;
    }
}
