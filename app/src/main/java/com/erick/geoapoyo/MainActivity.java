package com.erick.geoapoyo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.erick.geoapoyo.R;
import com.erick.geoapoyo.api.ApiInterface;
import com.erick.geoapoyo.api.LoginResponse;
import com.erick.geoapoyo.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText editTextCorreo, editTextContrasenia;
    Button botonIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        editTextCorreo = findViewById(R.id.correo);
        editTextContrasenia = findViewById(R.id.contrasenia);
        botonIniciarSesion = findViewById(R.id.boton_iniciar_sesion);

        botonIniciarSesion.setOnClickListener(view -> {
            // Obtener los valores de correo y contraseña ingresados por el usuario
            String correo = editTextCorreo.getText().toString().trim();
            String contrasenia = editTextContrasenia.getText().toString().trim();

            // Verificar si los campos no están vacíos
            if (!correo.isEmpty() && !contrasenia.isEmpty()) {
                // Realizar la solicitud POST utilizando Retrofit
                ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
                Call<LoginResponse> call = apiInterface.getLoginInformation(correo, contrasenia);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            LoginResponse loginResponse = response.body();
                            String token = loginResponse.getToken();
                            // Manejar la respuesta del servidor aquí
                            Toast.makeText(MainActivity.this, "Token: " + token, Toast.LENGTH_SHORT).show();
                        } else {
                            // Manejar el error de respuesta del servidor aquí
                            Toast.makeText(MainActivity.this, "Error en la solicitud", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        // Manejar el fallo de la llamada aquí
                        Toast.makeText(MainActivity.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                // Mostrar mensaje de error si algún campo está vacío
                Toast.makeText(MainActivity.this, "Por favor, ingrese correo y contraseña", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
