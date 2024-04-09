package com.erick.geoapoyo.api;

import com.google.gson.annotations.SerializedName;

public class LoginBody {
    @SerializedName("correo")
    private String correo;

    @SerializedName("contrasenia")
    private String contrasenia;

    public LoginBody(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
