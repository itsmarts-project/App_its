package com.erick.geoapoyo.api;

import com.erick.geoapoyo.ApiInterface;

import okhttp3.OkHttpClient;
import okhttp3.Request;
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
        if (retrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("https://geoapoyosapi-46nub.ondigitalocean.app/")
                    .addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.client(new OkHttpClient.Builder()
                            .addInterceptor(chain -> {
                                Request original = chain.request();
                                Request request = original.newBuilder()
                                        .build();
                                return chain.proceed(request);
                            })
                            .build())
                    .build();
        }

        return retrofit.create(ApiInterface.class);
    }
}

//http://10.0.2.2:8080/ 