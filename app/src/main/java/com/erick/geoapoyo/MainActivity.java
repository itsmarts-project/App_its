package com.erick.geoapoyo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.erick.geoapoyo.api.MainViewModel;

public class MainActivity extends AppCompatActivity {
    EditText editTextCorreo, editTextContrasenia;
    Button botonIniciarSesion;
    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCorreo = findViewById(R.id.correo);
        editTextContrasenia = findViewById(R.id.contrasenia);
        botonIniciarSesion = findViewById(R.id.boton_iniciar_sesion);

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.getLoginSuccessEvent().observe(this, loginSuccess -> {
            if (loginSuccess) {
                Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, HomePage.class));
                finish();
            }
        });

        botonIniciarSesion.setOnClickListener(view -> {
            String correo = editTextCorreo.getText().toString().trim();
            String contrasenia = editTextContrasenia.getText().toString().trim();

            if (correo.isEmpty()) {
                Toast.makeText(MainActivity.this, "Ingrese su correo", Toast.LENGTH_SHORT).show();
                return;
            }

            if (contrasenia.isEmpty()) {
                Toast.makeText(MainActivity.this, "Ingrese su contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            mViewModel.login(correo, contrasenia);
        });
    }
}

