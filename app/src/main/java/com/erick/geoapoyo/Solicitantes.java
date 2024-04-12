package com.erick.geoapoyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.erick.geoapoyo.databinding.ActivitySolicitantesBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Tag;

public class Solicitantes extends AppCompatActivity {
    private List<UserData> userDataList = new ArrayList<>();
    private static final String TAG = String.valueOf(Solicitantes.class);

    interface RequestUser {
        @POST("visita/visitasPendientes")
        Call<UserData> getUser(@Body JSONObject id);
    }

    private ActivitySolicitantesBinding binding;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySolicitantesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.recyclerPersonas;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this, userDataList);
        recyclerView.setAdapter(adapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestUser requestUser = retrofit.create(RequestUser.class);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", 1); // o cualquier otro ID que necesites enviar
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonString = jsonObject;
        Log.e(TAG, "jsonString"+ jsonString);


        requestUser.getUser(jsonString).enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {

                if (response.isSuccessful() && response.body() != null) {
                } else {
                    Log.e("API call", "Response code: " + response.code());
                    if (response.errorBody() != null) {
                        try {
                            Log.e("API call", "Error response: " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e("API call", "Empty error body");
                    }
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Log.e("API call", "Error on API request", t);
            }
        });


    }
}
