package com.tallerwebi.dominio;

public enum TipoSuscripcion {
    Basica ("Básica", 5000),
    Premium ("Premium", 10000);

    private String nombre;
    private int precio;

    TipoSuscripcion(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }
}
