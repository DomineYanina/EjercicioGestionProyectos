package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.RepositorioTarea;
import com.tallerwebi.dominio.Tarea;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioTarea")
public class RepositorioTareaImpl implements RepositorioTarea {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioTareaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crearTarea(Tarea tareaNueva) {
        sessionFactory.getCurrentSession().save(tareaNueva);
    }

    @Override
    public List<Tarea> obtenerTodasLasTareas() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Tarea", Tarea.class)
                .getResultList();
    }

    @Override
    public Tarea obtenerTareaPorId(Long tareaId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Tarea where id = :tareaId", Tarea.class)
                .setParameter("tareaId", tareaId)
                .uniqueResult();
    }

    @Override
    public void actualizarTarea(Tarea tarea) {
        sessionFactory.getCurrentSession().update(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        sessionFactory.getCurrentSession().delete(tarea);
    }
}
