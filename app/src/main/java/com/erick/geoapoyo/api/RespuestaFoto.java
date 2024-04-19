package com.erick.geoapoyo.api;

import com.google.gson.annotations.SerializedName;

public class RespuestaFoto {

    @SerializedName("foto")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
