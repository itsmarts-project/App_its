package com.erick.geoapoyo;

import com.erick.geoapoyo.models.Domicilios;
import com.erick.geoapoyo.models.Solicitante;
import com.erick.geoapoyo.models.Usuario;
import com.erick.geoapoyo.models.Visitas;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Posts {

    @SerializedName("id")
    private int id;

    @SerializedName("usuario")
    private Usuario usuario;

    @SerializedName("visitas")
    private List<Visitas> visitas;

    @SerializedName("solicitantes")
    private List<Solicitante> solicitantes;

    @SerializedName("domicilios")
    private List<Domicilios> domicilios;

    public Posts() {
    }

    public Posts(int id, Usuario usuario, List<Visitas> visitas, List<Solicitante> solicitantes, List<Domicilios> domicilios) {
        this.id = id;
        this.usuario = usuario;
        this.visitas = visitas;
        this.solicitantes = solicitantes;
        this.domicilios = domicilios;
    }

    public Posts(int id) {
        this.id = id;
    }

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

    public List<Visitas> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visitas> visitas) {
        this.visitas = visitas;
    }

    public List<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(List<Solicitante> solicitantes) {
        this.solicitantes = solicitantes;
    }

    public List<Domicilios> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilios> domicilios) {
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
