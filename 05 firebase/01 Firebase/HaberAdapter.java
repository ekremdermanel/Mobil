package com.example.okulhaber;

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

public class HaberAdapter extends RecyclerView.Adapter<HaberAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Haber> arrayList;

    public HaberAdapter(Context context, ArrayList<Haber> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.haber_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtBaslik.setText(arrayList.get(position).baslik);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Haber haber = arrayList.get(holder.getAdapterPosition());
                Intent intent = new Intent(context,DetayActivity.class);
                intent.putExtra("id",haber.id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtBaslik;
        CardView cardView;
        ImageView imgHaber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            txtBaslik = itemView.findViewById(R.id.txtBaslik);
            imgHaber = itemView.findViewById(R.id.imgHaber);
        }
    }
}