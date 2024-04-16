package com.erick.geoapoyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.erick.geoapoyo.api.PostAdapter;
import com.erick.geoapoyo.api.RetrofitClientInstance;
import com.erick.geoapoyo.models.Solicitante;
import com.erick.geoapoyo.Posts;
import com.erick.geoapoyo.models.Usuario;

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
    ImageButton boton_mapa_sol;
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

        boton_mapa_sol = findViewById(R.id.boton_mapa_sol);

        fetchPosts();


        toolbar = findViewById(R.id.detail_activity_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(R.string.app_name);

        boton_mapa_sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Solicitantes_pantalla.this, Mapa.class);
                startActivity(intent);
            }
        });
    }

    private void fetchPosts() {
        Posts idBody = new Posts(1);
        RetrofitClientInstance.getRetrofitClient().getPosts(idBody).enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                if(response.isSuccessful() && response.body() != null) {
                    Posts posts = response.body(); // Crear una instancia de Posts con la respuesta
                    Usuario usuario = posts.getUsuario();
                    Log.i("API_Response", "Usuario: " + usuario.getNombre() + " " + usuario.getPrimerApellido());

                    // Accede a la lista de solicitantes y procesa cada uno
                    List<Solicitante> solicitantes = posts.getSolicitantes();
                    for (Solicitante solicitante : solicitantes) {
                        Log.i("API_Response", "Solicitante: " + solicitante.getNombre() + " " + solicitante.getPrimerApellido());
                    }

                    //Log.i("API_Response", "REsponse: " + posts.usuario.get("nombre"));

                    //HACE FOR PARA LOS DATOS
                    //for(int i=0; i<posts.usuario.size(); i++){
                    //  Log.e("API_Response", "Usuario: " + posts.usuario.get("nombre"));
                    //}

                    //Posts posts = new Posts();
                    //posts.usuarios

                } else {
                    // La API no respondió correctamente
                    Log.e("API_Response", "Error: " + response);
                }
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Toast.makeText(Solicitantes_pantalla.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("API_Request", "Error: " + t.getMessage());
            }
        });
    }
}