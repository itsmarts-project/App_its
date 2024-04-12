package com.erick.geoapoyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import com.erick.geoapoyo.databinding.ActivityMapaBinding;

public class Mapa extends AppCompatActivity {

     ActivityMapaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.botonSolicitantes.setOnClickListener(v -> {
            Intent intent = new Intent(Mapa.this, Solicitantes.class);
            startActivity(intent);
        });

        binding.botonAjustes.setOnClickListener(v -> {
            Intent intent = new Intent(Mapa.this, Settings.class);
            startActivity(intent);
        });
    }
}