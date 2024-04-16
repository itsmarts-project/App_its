package com.erick.geoapoyo.api;

import com.erick.geoapoyo.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    public static Retrofit retrofit;

    public static Retrofit getInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://geoapoyosapi-46nub.ondigitalocean.app/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiInterface getRetrofitClient(String token) {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://geoapoyosapi-46nub.ondigitalocean.app/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiInterface.class);
    }
}

//http://10.0.2.2:8080/ 