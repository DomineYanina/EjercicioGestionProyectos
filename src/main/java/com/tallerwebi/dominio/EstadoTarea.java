package com.tallerwebi.dominio;

public enum EstadoTarea {
    Pendiente("Pendiente"),
    En_Proceso("En proceso"),
    Terminada("Terminada");

    private String nombre;

    EstadoTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
