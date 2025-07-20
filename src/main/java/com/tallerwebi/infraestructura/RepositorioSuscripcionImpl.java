package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Cliente;
import com.tallerwebi.dominio.RepositorioSuscripcion;
import com.tallerwebi.dominio.Suscripcion;
import com.tallerwebi.dominio.TipoSuscripcion;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("repositorioSuscripcion")
public class RepositorioSuscripcionImpl implements RepositorioSuscripcion {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioSuscripcionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Suscripcion obtenerSuscripcionPorId(Long suscripcionId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Suscripcion where id = :id";
        Query<Suscripcion> query = session.createQuery(hql, Suscripcion.class);
        query.setParameter("id", suscripcionId);
        Suscripcion suscripcion = query.uniqueResult();
        if (suscripcion == null) {
            return null;
        }
        return suscripcion;
    }

    @Override
    @Transactional
    public List<Cliente> obtenerClientesPorSuscripcion(Long suscripcionId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Suscripcion where id = :id";
        Query<Suscripcion> query = session.createQuery(hql, Suscripcion.class);
        query.setParameter("id", suscripcionId);
        Suscripcion suscripcion = query.uniqueResult();
        if (suscripcion == null) {
            return java.util.Collections.emptyList();
        }
        return suscripcion.getClientes();
    }

    @Override
    @Transactional
    public void actualizarSuscripcion(Suscripcion suscripcion) {
        sessionFactory.getCurrentSession().update(suscripcion);
    }

    @Override
    @Transactional
    public List<Suscripcion> obtenerTodasSuscripciones() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Suscripcion", Suscripcion.class)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Cliente> obtenerClientesPorTipoSuscripcion(TipoSuscripcion tipoSuscripcion) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Suscripcion where tipo = :tipoSuscripcion";
        Query<Suscripcion> query = session.createQuery(hql, Suscripcion.class);
        query.setParameter("tipoSuscripcion", tipoSuscripcion);
        Suscripcion suscripcion = query.uniqueResult();
        if (suscripcion == null) {
            return java.util.Collections.emptyList();
        }
        Hibernate.initialize(suscripcion.getClientes());
        return suscripcion.getClientes();
    }
}
