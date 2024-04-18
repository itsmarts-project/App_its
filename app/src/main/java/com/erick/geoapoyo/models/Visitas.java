package com.erick.geoapoyo.models;

import java.io.Serializable;
import java.util.List;

public class Visitas implements Serializable {

    String idVisita;
    String confirmacionSolicitante;
    String estatus;
    String razon;
    String latitudVisita;
    String longitudVisita;
    String fecha;
    String hora;
    String fotoDomicilio;
    String fotoIdentidicacion;
    String fechaVisita;
    String solicitante_idSolicitante;
    String usuario_idUsuario;

    public Visitas(String idVisita, String confirmacionSolicitante, String estatus, String razon, String latitudVisita, String longitudVisita, String fecha, String hora, String fotoDomicilio, String fotoIdentidicacion, String fechaVisita, String solicitante_idSolicitante, String usuario_idUsuario) {
        this.idVisita = idVisita;
        this.confirmacionSolicitante = confirmacionSolicitante;
        this.estatus = estatus;
        this.razon = razon;
        this.latitudVisita = latitudVisita;
        this.longitudVisita = longitudVisita;
        this.fecha = fecha;
        this.hora = hora;
        this.fotoDomicilio = fotoDomicilio;
        this.fotoIdentidicacion = fotoIdentidicacion;
        this.fechaVisita = fechaVisita;
        this.solicitante_idSolicitante = solicitante_idSolicitante;
        this.usuario_idUsuario = usuario_idUsuario;
    }

    public Visitas() {

    }

    public String getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(String idVisita) {
        this.idVisita = idVisita;
    }

    public String getConfirmacionSolicitante() {
        return confirmacionSolicitante;
    }

    public void setConfirmacionSolicitante(String confirmacionSolicitante) {
        this.confirmacionSolicitante = confirmacionSolicitante;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getLatitudVisita() {
        return latitudVisita;
    }

    public void setLatitudVisita(String latitudVisita) {
        this.latitudVisita = latitudVisita;
    }

    public String getLongitudVisita() {
        return longitudVisita;
    }

    public void setLongitudVisita(String longitudVisita) {
        this.longitudVisita = longitudVisita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFotoDomicilio() {
        return fotoDomicilio;
    }

    public void setFotoDomicilio(String fotoDomicilio) {
        this.fotoDomicilio = fotoDomicilio;
    }

    public String getFotoIdentidicacion() {
        return fotoIdentidicacion;
    }

    public void setFotoIdentidicacion(String fotoIdentidicacion) {
        this.fotoIdentidicacion = fotoIdentidicacion;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getSolicitante_idSolicitante() {
        return solicitante_idSolicitante;
    }

    public void setSolicitante_idSolicitante(String solicitante_idSolicitante) {
        this.solicitante_idSolicitante = solicitante_idSolicitante;
    }

    public String getUsuario_idUsuario() {
        return usuario_idUsuario;
    }

    public void setUsuario_idUsuario(String usuario_idUsuario) {
        this.usuario_idUsuario = usuario_idUsuario;
    }
}

