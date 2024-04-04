package com.erick.geoapoyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.erick.geoapoyo.databinding.ActivityHomePageBinding;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_activity_toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycler_personas);

        List<Persona> Personas = new ArrayList<Persona>();
        Personas.add(new Persona("Erick", "Villaseñor", "Jiménez", "UTL", R.drawable.erick));
        Personas.add(new Persona("Alexis", "Ramos", "Alvarez", "Universidad Tecnológica", R.drawable.erick));
        Personas.add(new Persona("Regino", "Gonzales", "Sanchez", "Instituto Politécnico", R.drawable.erick));
        Personas.add(new Persona("Oscar", "Mancilla", "Gasca", "Universidad de Artes", R.drawable.erick));
        Personas.add(new Persona("Birom", "Granados", "Conchas", "Colegio Nacional", R.drawable.erick));
        Personas.add(new Persona("Sergio", "Martínez", "Jiménez", "Universidad Internacional", R.drawable.erick));
        Personas.add(new Persona("Ana", "Blanco", "Nieto", "Escuela Superior de Ingeniería", R.drawable.erick));
        Personas.add(new Persona("Fernando", "Vega", "Castaño", "Centro de Estudios Superiores", R.drawable.erick));
        Personas.add(new Persona("Elena", "Molina", "Campos", "Instituto de Tecnología", R.drawable.erick));
        Personas.add(new Persona("Oscar", "López", "Herrera", "Universidad de Ciencias", R.drawable.erick));
        Personas.add(new Persona("Teresa", "Ramírez", "García", "Facultad de Derecho", R.drawable.erick));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), Personas));

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
}