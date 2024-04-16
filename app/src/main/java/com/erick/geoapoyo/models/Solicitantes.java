package com.erick.geoapoyo.models;

public class Solicitantes {
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

    public Solicitantes(String idSolicitante, String nombre, String primerApellido, String segundoApellido, String genero, String edad, String correo, String fechaAlta, String montoAprobado, String montoSolicitado, String estatus, String universidad, String fotoSolicitante) {
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


}
