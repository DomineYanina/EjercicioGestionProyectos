package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Tarea;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoViewModel {
    private long id;
    private String nombre;
    private String rol;
    private List<Tarea> tareas = new ArrayList<>();

    public EmpleadoViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
