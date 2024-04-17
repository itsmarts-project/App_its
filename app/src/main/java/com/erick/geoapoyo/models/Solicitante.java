package com.erick.geoapoyo.models;

import java.io.Serializable;

public class Solicitante implements Serializable {
    String idSolicitante;
    String nombre;
    String primerApellido;
    String segundoApellido;
    String genero;
    String edad;
    String correo;
    String fechaAlta;
    String montoAprobado;
    String montoSolicitado;
    String estatus;
    String universidad;
    String fotoSolicitante;

    public Solicitante(String idSolicitante, String nombre, String primerApellido, String segundoApellido, String genero, String edad, String correo, String fechaAlta, String montoAprobado, String montoSolicitado, String estatus, String universidad, String fotoSolicitante) {
        this.idSolicitante = idSolicitante;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.genero = genero;
        this.edad = edad;
        this.correo = correo;
        this.fechaAlta = fechaAlta;
        this.montoAprobado = montoAprobado;
        this.montoSolicitado = montoSolicitado;
        this.estatus = estatus;
        this.universidad = universidad;
        this.fotoSolicitante = fotoSolicitante;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getMontoAprobado() {
        return montoAprobado;
    }

    public void setMontoAprobado(String montoAprobado) {
        this.montoAprobado = montoAprobado;
    }

    public String getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(String montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getFotoSolicitante() {
        return fotoSolicitante;
    }

    public void setFotoSolicitante(String fotoSolicitante) {
        this.fotoSolicitante = fotoSolicitante;
    }
}
