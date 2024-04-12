package com.erick.geoapoyo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.ViewHolder> {

    private List<UserData.DataClass> userDataList;

    public UserDataAdapter(List<UserData.DataClass> userDataList) {
        this.userDataList = userDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.persona_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserData.DataClass user = userDataList.get(position);
        holder.nombrePerson.setText(user.getNombre() + " " + user.getPrimerApellido());
        holder.universidadPerson.setText(user.getUniversidad());

    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombrePerson;
        public TextView universidadPerson;
        public ImageView imagePerson;

        public ViewHolder(View itemView) {
            super(itemView);
            nombrePerson = itemView.findViewById(R.id.nombre_person);
            universidadPerson = itemView.findViewById(R.id.universidad_person);
        }
    }
}
