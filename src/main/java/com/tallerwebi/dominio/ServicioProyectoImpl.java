package com.tallerwebi.dominio;

import com.tallerwebi.presentacion.ProyectoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioProyecto")
public class ServicioProyectoImpl implements ServicioProyecto {

    private final RepositorioProyecto repositorioProyecto;

    @Autowired
    public ServicioProyectoImpl(RepositorioProyecto repositorioProyecto) {
        this.repositorioProyecto = repositorioProyecto;
    }

    @Override
    public void crearProyecto(Proyecto proyecto) {
        repositorioProyecto.crearProyecto(proyecto);
    }

    @Override
    public List<Proyecto> obtenerTodosLosProyectos() {
        return repositorioProyecto.obtenerTodosLosProyectos();
    }

    @Override
    public Proyecto obtenerProyectoPorId(long id) {
        return repositorioProyecto.obtenerProyectoPorId(id);
    }

    @Override
    public void eliminarProyecto(Proyecto proyecto) {
        repositorioProyecto.eliminarProyecto(proyecto);
    }

    @Override
    public List<Proyecto> obtenerTodosLosProyectosDesarrollo() {
        return repositorioProyecto.obtenerTodosLosProyectosDesarrollo();
    }

    @Override
    public List<Proyecto> obtenerTodosLosProyectosMarketing() {
        return repositorioProyecto.obtenerTodosLosProyectosMarketing();
    }

    @Override
    public List<Proyecto> obtenerTodosLosProyectosInvestigacion() {
        return repositorioProyecto.obtenerTodosLosProyectosInvestigacion();
    }

    // Implementación de los métodos del servicio
    // Ejemplo: public void crearProyecto(Proyecto proyecto) { ... }
}
