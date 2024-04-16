package com.erick.geoapoyo;

import com.erick.geoapoyo.models.Domicilios;
import com.erick.geoapoyo.models.Usuario;
import com.erick.geoapoyo.models.Visitas;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Posts {

    @SerializedName("id")
    private int id;

    @SerializedName("usuario")
    private Usuario usuario;

    @SerializedName("visitas")
    private JsonArray visitas;

    @SerializedName("solicitantes")
    private JsonArray solicitantes;

    @SerializedName("domicilios")
    private JsonArray domicilios;


    public Posts(Usuario usuario, JsonArray visitas, JsonArray solicitantes, JsonArray domicilios) {
        this.usuario = usuario;
        this.visitas = visitas;
        this.solicitantes = solicitantes;
        this.domicilios = domicilios;
    }

    // Constructor para ID
    public Posts(int id) {
        this.id = id;
    }

    // Constructor vacío
    public Posts() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public JsonArray getVisitas() {
        return visitas;
    }

    public void setVisitas(JsonArray visitas) {
        this.visitas = visitas;
    }

    public JsonArray getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(JsonArray solicitantes) {
        this.solicitantes = solicitantes;
    }

    public JsonArray getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(JsonArray domicilios) {
        this.domicilios = domicilios;
    }


    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", visitas=" + visitas +
                ", solicitantes=" + solicitantes +
                ", domicilios=" + domicilios +
                '}';
    }
}
