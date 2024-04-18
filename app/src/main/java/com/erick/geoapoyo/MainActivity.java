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
    private EditText editTextCorreo;
    private EditText editTextContrasenia;
    private Button botonIniciarSesion;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCorreo = findViewById(R.id.correo);
        editTextContrasenia = findViewById(R.id.contrasenia);
        botonIniciarSesion = findViewById(R.id.boton_iniciar_sesion);

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        observeLoginSuccess();
        setUpSignInButton();
    }

    private void observeLoginSuccess() {
        mViewModel.getLoginSuccessEvent().observe(this, loginSuccess -> {
            if (loginSuccess) {
                Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Solicitantes_pantalla.class));
                finish();
            }
        });
    }

    private void setUpSignInButton() {
        botonIniciarSesion.setOnClickListener(view -> {
            String correo = editTextCorreo.getText().toString().trim();
            String contrasenia = editTextContrasenia.getText().toString().trim();

            if (validateEmailAndPassword(correo, contrasenia)) {
                mViewModel.login(correo, contrasenia);
            }
        });
    }

    private boolean validateEmailAndPassword(String correo, String contrasenia) {
        if (correo.isEmpty()) {
            Toast.makeText(MainActivity.this, "Ingrese su correo", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!isValidEmail(correo)) {
            Toast.makeText(MainActivity.this, "Correo electrónico no válido", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (contrasenia.isEmpty()) {
            Toast.makeText(MainActivity.this, "Ingrese su contraseña", Toast.LENGTH_SHORT).show();
            return false;
        } else if (contrasenia.length() < 5) {
            Toast.makeText(MainActivity.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}
