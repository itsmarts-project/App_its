package com.erick.geoapoyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.erick.geoapoyo.api.PostAdapter;
import com.erick.geoapoyo.api.RetrofitClientInstance;
import com.erick.geoapoyo.databinding.ActivitySolicitantesBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Solicitantes_pantalla extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    PostAdapter adapter;
    List<Posts> postsList = new ArrayList<>();
    ImageButton boton_mapa;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitantes);

        recyclerView = findViewById(R.id.recycler_personas);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostAdapter(postsList);
        recyclerView.setAdapter(adapter);

        boton_mapa = findViewById(R.id.boton_mapa_sol);

        fetchPosts();

        botonMapa();

        toolbar = findViewById(R.id.detail_activity_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(R.string.app_name);
    }

    private void fetchPosts() {
        RetrofitClientInstance.getRetrofitClient().getPosts(1).enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(response.isSuccessful() && response.body() != null){
                    // La API respondió correctamente, ahora registramos la respuesta en el log
                    Log.d("API_Response", "Response: " + response.body().toString());

                    postsList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    // La API no respondió correctamente
                    Log.e("API_Response", "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                // Hubo un error al hacer la solicitud
                Toast.makeText(Solicitantes_pantalla.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("API_Request", "Error: " + t.getMessage());
            }
        });
    }

    private void botonMapa() {
        boton_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Solicitantes_pantalla.this, Mapa.class);
                startActivity(intent);
            }
        });
    }

}