package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.ProyectoViewModel;

import java.util.List;

public interface ServicioProyecto {
    void crearProyecto(Proyecto proyecto);

    List<Proyecto> obtenerTodosLosProyectos();

    Proyecto obtenerProyectoPorId(long id);

    void eliminarProyecto(Proyecto proyecto);

    List<Proyecto> obtenerTodosLosProyectosDesarrollo();

    List<Proyecto> obtenerTodosLosProyectosMarketing();

    List<Proyecto> obtenerTodosLosProyectosInvestigacion();
}
