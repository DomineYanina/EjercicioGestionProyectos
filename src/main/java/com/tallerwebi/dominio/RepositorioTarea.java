package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioTarea {
    void crearTarea(Tarea tareaNueva);

    List<Tarea> obtenerTodasLasTareas();

    Tarea obtenerTareaPorId(Long tareaId);

    void actualizarTarea(Tarea tarea);

    void eliminarTarea(Tarea tarea);
}
