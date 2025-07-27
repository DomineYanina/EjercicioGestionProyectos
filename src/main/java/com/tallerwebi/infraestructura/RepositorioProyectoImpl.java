package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Proyecto;
import com.tallerwebi.dominio.RepositorioProyecto;
import com.tallerwebi.dominio.TipoProyecto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioProyecto")
public class RepositorioProyectoImpl implements RepositorioProyecto {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioProyectoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crearProyecto(Proyecto proyecto) {
        sessionFactory.getCurrentSession().save(proyecto);
    }

    @Override
    public List<Proyecto> obtenerTodosLosProyectos() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Proyecto", Proyecto.class)
                .getResultList();
    }

    @Override
    public Proyecto obtenerProyectoPorId(long id) {
        return sessionFactory.getCurrentSession()
                .get(Proyecto.class, id);
    }

    @Override
    public void eliminarProyecto(Proyecto proyecto) {
        sessionFactory.getCurrentSession().delete(proyecto);
    }

    @Override
    public List<Proyecto> obtenerTodosLosProyectosDesarrollo() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Proyecto where tipo = :tipo", Proyecto.class)
                .setParameter("tipo", TipoProyecto.Desarrollo)
                .getResultList();
    }

    @Override
    public List<Proyecto> obtenerTodosLosProyectosMarketing() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Proyecto where tipo = :Tipo", Proyecto.class)
                .setParameter("Tipo", TipoProyecto.Marketing)
                .getResultList();
    }

    @Override
    public List<Proyecto> obtenerTodosLosProyectosInvestigacion() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Proyecto where tipo = :tipo", Proyecto.class)
                .setParameter("tipo", TipoProyecto.Investigacion)
                .getResultList();
    }
}
