package com.erick.geoapoyo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nombre_person;
    TextView universidad_person;

    public MyViewHolder(View itemView) {
        super(itemView);
        nombre_person = itemView.findViewById(R.id.nombre_person);
        universidad_person = itemView.findViewById(R.id.universidad_person);
    }
}
