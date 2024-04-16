package com.erick.geoapoyo.models;

public class Domicilios {
    String idDomicilio;
    String calle;
    String numeroExterior;
    String numeroInterior;
    String colonia;
    String ciudad;
    String estado;
    String latitud;
    String longitud;
    String solicitante_idSolicitante;

    public Domicilios(String idDomicilio, String calle, String numeroExterior, String numeroInterior, String colonia, String ciudad, String estado, String latitud, String longitud, String solicitante_idSolicitante) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.latitud = latitud;
        this.longitud = longitud;
        this.solicitante_idSolicitante = solicitante_idSolicitante;
    }

    public String getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(String idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getSolicitante_idSolicitante() {
        return solicitante_idSolicitante;
    }

    public void setSolicitante_idSolicitante(String solicitante_idSolicitante) {
        this.solicitante_idSolicitante = solicitante_idSolicitante;
    }
}
