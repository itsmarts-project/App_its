package com.erick.geoapoyo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.erick.geoapoyo.models.Solicitante;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Mapa extends AppCompatActivity {
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private static final int REQUEST_GALLERY_PERMISSION = 3;
    private static final int REQUEST_CAMERA_PERMISSION = 4;

    private Toolbar toolbar;
    private ImageView cerrar_sesion, imageViewGallery, imageViewPreview;
    private ImageButton boton_solicitantes, boton_settings, imageButtonCamera;
    private EditText editTextX, editTextY, editTextDate;
    private TextView nombre, universidad;
    private Bitmap capturedImage;
    private String selectedImagePath, capturedImagePath;

    private LocationManager locationManager;
    private LocationListener locationListener;

    private Solicitante solicitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        setupUI();
        setupLocationPermissions();
        setupCameraPermissions();
    }

    private void setupUI() {
        cerrar_sesion = findViewById(R.id.salir);
        boton_settings = findViewById(R.id.boton_ajustes);
        boton_solicitantes = findViewById(R.id.boton_solicitantes);
        imageButtonCamera = findViewById(R.id.imageButtonCamera);
        imageViewGallery = findViewById(R.id.imageViewGallery);
        imageViewPreview = findViewById(R.id.vista_imagen);
        editTextX = findViewById(R.id.eje_x);
        editTextY = findViewById(R.id.eje_y);
        editTextDate = findViewById(R.id.editTextDate);
        nombre = findViewById(R.id.map_nombre);
        universidad = findViewById(R.id.map_universidad);
        toolbar = findViewById(R.id.detail_activity_toolbar);

        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);

        setDate();
        setupListeners();
        populateSpinners();
        displaySolicitanteInfo();
    }

    private void setupLocationPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        } else {
            initializeLocationListener();
        }
    }

    private void setupCameraPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
        }
    }

    private void setDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        editTextDate.setText(dateFormat.format(calendar.getTime()));
    }

    private void setupListeners() {
        cerrar_sesion.setOnClickListener(v -> logOut());
        boton_settings.setOnClickListener(v -> startActivity(new Intent(Mapa.this, Settings.class)));
        boton_solicitantes.setOnClickListener(v -> startActivity(new Intent(Mapa.this, Solicitantes_pantalla.class)));
        imageViewGallery.setOnClickListener(v -> openGallery());
        imageButtonCamera.setOnClickListener(v -> openCamera());
    }

    private void populateSpinners() {
        setupSpinner(R.id.estatus_opciones, R.array.opciones_estatus);
        setupSpinner(R.id.razon_opciones, R.array.razon_opciones);
    }

    private void setupSpinner(int spinnerId, int arrayResourceId) {
        Spinner spinner = findViewById(spinnerId);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrayResourceId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void displaySolicitanteInfo() {
        Solicitante solicitante = (Solicitante) getIntent().getSerializableExtra("solicitante");
        if (solicitante != null) {
            nombre.setText(String.format("%s %s %s", solicitante.getNombre(), solicitante.getPrimerApellido(), solicitante.getSegundoApellido()));
            universidad.setText(solicitante.getUniversidad());
            setSolicitante(solicitante);
        }
    }

    private void logOut() {
        Intent intent = new Intent(Mapa.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initializeLocationListener() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                editTextX.setText(String.valueOf(location.getLatitude()));
                editTextY.setText(String.valueOf(location.getLongitude()));
            }

            @Override
            public void onProviderEnabled(@NonNull String provider) {}
            @Override
            public void onProviderDisabled(@NonNull String provider) {}
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {}
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (galleryIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(galleryIntent, REQUEST_GALLERY_PERMISSION);
        } else {
            Toast.makeText(this, "No se encontró una aplicación de galería", Toast.LENGTH_SHORT).show();
        }
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File imageFile = createImageFile();
            if (imageFile != null) {
                capturedImagePath = imageFile.getAbsolutePath();
                imageViewPreview.setImageURI(Uri.fromFile(imageFile));
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File createImageFile() {
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        try {
            return File.createTempFile("image_", ".jpg", storageDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_PERMISSION && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            initializeLocationListener();
        }
        if (requestCode == REQUEST_CAMERA_PERMISSION && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            capturedImage = (Bitmap) extras.get("data");
            imageViewPreview.setImageBitmap(capturedImage);
        } else if (requestCode == REQUEST_GALLERY_PERMISSION && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            selectedImagePath = getPathFromURI(selectedImage);
            imageViewGallery.setImageURI(selectedImage);
        }
    }

    private String getPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor != null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String path = cursor.getString(column_index);
            cursor.close();
            return path;
        }
        return null;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }
}
