package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioProyecto {
    void crearProyecto(Proyecto proyecto);

    List<Proyecto> obtenerTodosLosProyectos();

    Proyecto obtenerProyectoPorId(long id);

    void eliminarProyecto(Proyecto proyecto);

    List<Proyecto> obtenerTodosLosProyectosDesarrollo();

    List<Proyecto> obtenerTodosLosProyectosMarketing();

    List<Proyecto> obtenerTodosLosProyectosInvestigacion();
}
