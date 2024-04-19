package com.erick.geoapoyo.models;

import com.google.gson.annotations.SerializedName;

public class Foto {
    @SerializedName("foto")
    private String foto;

    public Foto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
