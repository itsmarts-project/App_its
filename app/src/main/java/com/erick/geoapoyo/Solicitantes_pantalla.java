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
import android.widget.ImageView;
import android.widget.Toast;

import com.erick.geoapoyo.api.LoginBody;
import com.erick.geoapoyo.api.PostAdapter;
import com.erick.geoapoyo.api.RetrofitClientInstance;
import com.erick.geoapoyo.models.Solicitante;
import com.erick.geoapoyo.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Solicitantes_pantalla extends AppCompatActivity {

    private String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTEsImlhdCI6MTcxMzMxMzQ0MywiZXhwIjoxNzEzNTcyNjQzfQ.CRX8gJj3RbjBs2hzV23EF57LPSPgYEOEmWsPScbRG2A";
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    PostAdapter adapter;
    List<Solicitante> postsList = new ArrayList<>();
    ImageButton boton_mapa_sol, boton_ajustes;
    ImageView cerrar_sesion;
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
        cerrar_sesion = findViewById(R.id.salir);

        fetchPosts();
        boton_ajustes = findViewById(R.id.boton_ajustes);

        boton_ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Solicitantes_pantalla.this, Settings.class);
                startActivity(intent);
            }
        });


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

        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Solicitantes_pantalla.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    private void fetchPosts() {
        List<Integer> postIds = getPostIds();

        for (int id : postIds) {
            Posts idBody = new Posts(id);
            LoginBody login = new LoginBody();
            //  token = login.getToken();

            RetrofitClientInstance.getRetrofitClient(token).getPosts (idBody, token).enqueue(new Callback<Posts>() {
                @Override
                public void onResponse(Call<Posts> call, Response<Posts> response) {
                    if(response.isSuccessful() && response.body() != null) {
                        Posts posts = response.body();
                        Usuario usuario = posts.getUsuario();
                        Log.i("API_Response", "Usuario: " + usuario.getNombre() + " " + usuario.getPrimerApellido());

                        postsList.addAll(posts.getSolicitantes());

                        adapter.notifyDataSetChanged();

                        List<Solicitante> solicitantes = posts.getSolicitantes();
                        for (Solicitante solicitante : solicitantes) {
                            Log.i("API_Response", "Solicitante: " + solicitante.getNombre() + " " + solicitante.getPrimerApellido());
                        }
                    } else {
                        Log.e("API_Response", "Error1: " + response);
                    }
                }

                @Override
                public void onFailure(Call<Posts> call, Throwable t) {
                    Toast.makeText(Solicitantes_pantalla.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("API_Request", "Error2: " + t.getMessage());
                }
            });
        }
    }

    private int maxPostIds = 10;

    private List<Integer> getPostIds() {
        List<Integer> postIds = new ArrayList<>();
        for (int i = 1; i <= maxPostIds; i++) {
            postIds.add(i);
        }
        return postIds;
    }

}