package com.tallerwebi.dominio;

public enum TipoProyecto {
    Desarrollo("Desarrollo"),
    Marketing("Marketing"),
    Investigacion("Investigación");

    private String nombre;

    TipoProyecto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
