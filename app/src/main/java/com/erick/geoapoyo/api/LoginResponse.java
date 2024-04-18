package com.erick.geoapoyo.api;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("token")
    String token;

    public String getToken() {
        return token;
    }

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse() {
        this.token = token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}