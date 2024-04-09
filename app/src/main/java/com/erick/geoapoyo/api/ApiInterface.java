package com.erick.geoapoyo.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login") // Cambiado a POST ya que estás enviando datos
    Call<LoginResponse> getLoginInformation(@Field("correo") String correo, @Field("contrasenia") String contrasenia);
}
