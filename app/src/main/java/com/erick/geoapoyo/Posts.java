package com.erick.geoapoyo;

import com.erick.geoapoyo.models.Solicitante;
import com.erick.geoapoyo.models.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Posts {

    @SerializedName("id")
    private int id;

    @SerializedName("usuario")
    private Usuario usuario;

    @SerializedName("visitas")
    private JsonArray visitas;

    @SerializedName("solicitantes")
    private List<Solicitante> solicitantes; // Cambio de tipo de JsonArray a List<Solicitante>

    @SerializedName("domicilios")
    private JsonArray domicilios;

    public Posts(Usuario usuario, JsonArray visitas, List<Solicitante> solicitantes, JsonArray domicilios) {
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

    public List<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(List<Solicitante> solicitantes) {
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
