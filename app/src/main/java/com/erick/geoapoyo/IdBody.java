package com.erick.geoapoyo;

import com.google.gson.annotations.SerializedName;

public class IdBody {
    @SerializedName("id")
    private int id;

    public IdBody(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
