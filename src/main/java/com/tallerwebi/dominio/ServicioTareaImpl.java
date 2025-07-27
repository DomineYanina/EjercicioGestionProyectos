package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioTarea")
public class ServicioTareaImpl implements ServicioTarea {

    private RepositorioTarea repositorioTarea;

    @Autowired
    public ServicioTareaImpl(RepositorioTarea repositorioTarea) {
        this.repositorioTarea = repositorioTarea;
    }

    @Override
    public void crearTarea(Tarea tareaNueva) {
        repositorioTarea.crearTarea(tareaNueva);
    }

    @Override
    public List<Tarea> obtenerTodasLasTareas() {
        return repositorioTarea.obtenerTodasLasTareas();
    }

    @Override
    public Tarea obtenerTareaPorId(Long tareaId) {
        return repositorioTarea.obtenerTareaPorId(tareaId);
    }

    @Override
    public void actualizarTarea(Tarea tarea) {
        repositorioTarea.actualizarTarea(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        repositorioTarea.eliminarTarea(tarea);
    }
}
