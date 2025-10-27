package com.example.telefonrehberimobil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class KisiAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Kisi> arrayList;

    public KisiAdapter(Context context, ArrayList<Kisi> arrayList) {
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
                    inflate(R.layout.list_item, viewGroup, false);
        }

        Kisi kisi = (Kisi) getItem(i);

        TextView txtHarf = view.findViewById(R.id.txtHarf);
        TextView txtAdSoyad = view.findViewById(R.id.txtAdSoyad);
        CardView cardView = view.findViewById(R.id.cardView);

        txtHarf.setText(kisi.adSoyad.substring(0,1).toUpperCase());
        txtAdSoyad.setText(kisi.adSoyad);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetayActivity.class);
                intent.putExtra("id",kisi.id);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
