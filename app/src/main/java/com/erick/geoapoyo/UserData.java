package com.erick.geoapoyo;

public class UserData {

    DataClass data;

    public DataClass getData() {
        return data;
    }

    public void setData(DataClass data) {
        this.data = data;
    }

    class DataClass{
        private String idSolicitante;//o int
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String genero;
        private String edad;
        private String correo;
        private String fechaAlta;
        private String montoAprobado;
        private String montoSolicitado;
        private String estatus;
        private String universidad;
        private String fotoSolicitante;

        // Getters y setters
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
}
