package com.example.filmlistem;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Film> arrayList;
    SQLiteDatabase database;

    public FilmAdapter(Context context, ArrayList<Film> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        database = context.openOrCreateDatabase("FilmListemDB", MODE_PRIVATE, null);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textFilmAdi.setText(arrayList.get(position).filmAdi);
        holder.textPuan.setText(""+arrayList.get(position).puan);

        if(arrayList.get(position).fav==1){
            holder.imageFav.setColorFilter(Color.parseColor("#ff0000"));
        } else {
            holder.imageFav.setColorFilter(Color.parseColor("#000000"));
        }

        holder.imageFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = arrayList.get(holder.getAdapterPosition()).id;
                int fav= arrayList.get(holder.getAdapterPosition()).fav;
                fav = (fav==1) ? 0 : 1;
                String sorgu = "UPDATE filmler SET fav=? WHERE id=?";
                SQLiteStatement durumlar=database.compileStatement(sorgu);
                durumlar.bindLong(1,fav);
                durumlar.bindLong(2,id);
                durumlar.execute();

                arrayList.get(holder.getAdapterPosition()).fav=fav;
                notifyDataSetChanged();
            }
        });

        holder.imageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = arrayList.get(holder.getAdapterPosition()).id;
                String sorgu = "DELETE FROM filmler WHERE id=?";
                SQLiteStatement durumlar=database.compileStatement(sorgu);
                durumlar.bindLong(1,id);
                durumlar.execute();

                arrayList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textFilmAdi,textPuan;
        ImageView imageFav, imageDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textFilmAdi = itemView.findViewById(R.id.textFilmAdi);
            textPuan = itemView.findViewById(R.id.textPuan);
            imageFav = itemView.findViewById(R.id.imageFav);
            imageDelete = itemView.findViewById(R.id.imageDelete);
        }
    }
}
