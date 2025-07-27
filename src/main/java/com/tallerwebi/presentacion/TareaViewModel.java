package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.EstadoTarea;

public class TareaViewModel {
    private long id;
    private String nombre;
    private String descripcion;
    private EstadoTarea estado;
    private Long proyecto;
    private Long empleado;

    public TareaViewModel() {
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

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public Long getProyecto() {
        return proyecto;
    }

    public void setProyecto(Long proyecto) {
        this.proyecto = proyecto;
    }

    public Long getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Long empleado) {
        this.empleado = empleado;
    }
}
