package com.tallerwebi.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;
    private TipoProyecto tipo;
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Tarea> tareas = new ArrayList<>();

    public Proyecto() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProyecto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProyecto tipo) {
        this.tipo = tipo;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public void addTarea(Tarea tarea) {
        tareas.add(tarea);
        tarea.setProyecto(this);
    }

    public void removeTarea(Tarea tarea) {
        tareas.remove(tarea);
        tarea.setProyecto(null);
    }
}
