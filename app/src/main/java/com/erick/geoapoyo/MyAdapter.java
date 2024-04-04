package com.erick.geoapoyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Persona> Personas;

    public MyAdapter(Context context, List<Persona> Personas) {
        this.context = context;
        this.Personas = Personas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.persona_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nombre_person.setText(Personas.get(position).getNombre());
        holder.universidad_person.setText(Personas.get(position).getUniversidad());
        holder.image_person.setImageResource(Personas.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return Personas.size();
    }
}
