package com.erick.geoapoyo.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erick.geoapoyo.Posts;
import com.erick.geoapoyo.R;
import com.erick.geoapoyo.models.Solicitante;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Solicitante> solicitantesList;

    public PostAdapter(List<Solicitante> solicitantesList) {
        this.solicitantesList = solicitantesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.persona_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Solicitante solicitante = solicitantesList.get(position);
        holder.nombre_person.setText(solicitante.getNombre() + " " + solicitante.getPrimerApellido() + " " + solicitante.getSegundoApellido());
        holder.universidad_person.setText(solicitante.getUniversidad());
    }

    @Override
    public int getItemCount() {
        return solicitantesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre_person;
        TextView universidad_person;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre_person = itemView.findViewById(R.id.nombre_person);
            universidad_person = itemView.findViewById(R.id.universidad_person);
        }
    }
}