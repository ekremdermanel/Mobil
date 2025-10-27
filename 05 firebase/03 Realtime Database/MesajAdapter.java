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

public class MesajAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Mesaj> arrayList;

    public MesajAdapter(Context context, ArrayList<Mesaj> arrayList) {
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

        Mesaj mesaj = (Mesaj) getItem(i);

        TextView txtGonderen = view.findViewById(R.id.txtGonderen);
        TextView txtIcerik = view.findViewById(R.id.txtIcerik);
        LinearLayout layout = view.findViewById(R.id.layout);

        txtGonderen.setText(mesaj.gonderen);
        txtIcerik.setText(mesaj.icerik);

        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                FirebaseDatabase.getInstance().getReference("mesajlar").child(mesaj.id).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //Toast.makeText(context, "Silindi", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });



        return view;
    }
}
