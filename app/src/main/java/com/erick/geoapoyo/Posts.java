package com.erick.geoapoyo;

import com.google.gson.annotations.SerializedName;

public class Posts {

    @SerializedName("nombre")
    String nombre;

    @SerializedName("primerApellido")
    String primerApellido;

    @SerializedName("segundoApellido")
    String segundoApellido;

    @SerializedName("estatus")
    String estatus;

    @SerializedName("universidad")
    String universidad;

    @SerializedName("fotoSolicitante")
    String fotoSolicitante;

    public Posts(String nombre, String primerApellido, String segundoApellido, String estatus, String universidad, String fotoSolicitante) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.estatus = estatus;
        this.universidad = universidad;
        this.fotoSolicitante = fotoSolicitante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    public String getEstatus() {
        return estatus;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    public String getUniversidad() {
        return universidad;
    }

    public void setFotoSolicitante(String fotoSolicitante) {
        this.fotoSolicitante = fotoSolicitante;
    }
    public String getFotoSolicitante() {
        return fotoSolicitante;
    }

}