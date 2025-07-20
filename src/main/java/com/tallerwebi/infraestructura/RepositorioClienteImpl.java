package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Cliente;
import com.tallerwebi.dominio.RepositorioCliente;
import com.tallerwebi.dominio.Suscripcion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("repositorioCliente")
public class RepositorioClienteImpl implements RepositorioCliente {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioClienteImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Cliente obtenerClientePorId(Long clienteId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Cliente where id = :id";
        Query<Cliente> query = session.createQuery(hql, Cliente.class);
        query.setParameter("id", clienteId);
        Cliente cliente = query.uniqueResult();
        if (cliente == null) {
            return null;
        }
        return cliente;
    }

    @Override
    @Transactional
    public Cliente obtenerClientePorDNI(Long dni) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Cliente where DNI = :dni";
        Query<Cliente> query = session.createQuery(hql, Cliente.class);
        query.setParameter("dni", dni);
        Cliente cliente = query.uniqueResult();
        if (cliente == null) {
            return null;
        }
        return cliente;
    }
}
