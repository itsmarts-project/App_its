package com.erick.geoapoyo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("visita/visitasPendientes")
    Call<Posts> getPosts(@Body Posts idBody, @Header("token") String token);
}
