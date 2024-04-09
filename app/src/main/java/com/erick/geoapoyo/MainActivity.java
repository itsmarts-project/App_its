package com.erick.geoapoyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        // Inicializar vistas
        editTextCorreo = findViewById(R.id.correo);
        editTextContrasenia = findViewById(R.id.contrasenia);
        botonIniciarSesion = findViewById(R.id.boton_iniciar_sesion);

        // Inicializar ViewModel
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Observar el evento de inicio de sesión exitoso
        mViewModel.getLoginSuccessEvent().observe(this, loginSuccess -> {
            if (loginSuccess) {
                // Mostrar Toast de inicio de sesión exitoso
                Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                // Iniciar la pantalla de HomePage
                startActivity(new Intent(MainActivity.this, HomePage.class));
                finish(); // Opcional: cerrar la actividad actual si ya no es necesaria
            }
        });

        botonIniciarSesion.setOnClickListener(view -> {
            // Obtener valores del correo y la contraseña
            String correo = editTextCorreo.getText().toString().trim();
            String contrasenia = editTextContrasenia.getText().toString().trim();

            // Verificar si el correo está vacío
            if (correo.isEmpty()) {
                Toast.makeText(MainActivity.this, "Ingrese su correo", Toast.LENGTH_SHORT).show();
                return; // Salir del método para evitar la ejecución adicional
            }

            // Verificar si la contraseña está vacía
            if (contrasenia.isEmpty()) {
                Toast.makeText(MainActivity.this, "Ingrese su contraseña", Toast.LENGTH_SHORT).show();
                return; // Salir del método para evitar la ejecución adicional
            }

            // Intentar iniciar sesión
            mViewModel.login(correo, contrasenia);
        });
    }
}

