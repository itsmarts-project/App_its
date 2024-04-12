package com.erick.geoapoyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.erick.geoapoyo.databinding.ActivitySettingsBinding;

public class Settings extends AppCompatActivity {

    ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.botonSolicitantes.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, Solicitantes.class);
            startActivity(intent);
        });

        binding.botonMapa.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, Mapa.class);
            startActivity(intent);
        });
    }
}