package com.erick.geoapoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Solicitante> solicitantes;

    public MyAdapter(Context context, List<Solicitante> solicitantes) {
        this.context = context;
        this.solicitantes = solicitantes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.persona_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nombre_person.setText(solicitantes.get(position).getNombre());
        holder.universidad_person.setText(solicitantes.get(position).getUniversidad());
        holder.image_person.setImageResource(solicitantes.get(position).getFoto());
        holder.estatus.setImageResource(solicitantes.get(position).getEstatus());
    }

    @Override
    public int getItemCount() {
        return solicitantes.size();
    }
}
