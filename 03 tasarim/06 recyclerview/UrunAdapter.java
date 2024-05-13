package com.example.recyclerviewornek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UrunAdapter extends RecyclerView.Adapter<UrunAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Urun> arrayList;

    public UrunAdapter(Context context, ArrayList<Urun> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.urun_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(arrayList.get(position).urunAdi);
        holder.textView2.setText(arrayList.get(position).fiyat + " TL");
        holder.cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, holder.getAdapterPosition() + ". index tıklandı", Toast.LENGTH_SHORT).show();
                Urun urun = arrayList.get(holder.getAdapterPosition());
                Intent intent = new Intent(context,DetayActivity.class);
                intent.putExtra("urun",urun);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        CardView cardView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            cardView1 = itemView.findViewById(R.id.cardView1);
        }
    }
}
