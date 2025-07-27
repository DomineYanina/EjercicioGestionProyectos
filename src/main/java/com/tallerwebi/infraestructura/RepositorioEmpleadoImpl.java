package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Empleado;
import com.tallerwebi.dominio.RepositorioEmpleado;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioEmpleado")
public class RepositorioEmpleadoImpl implements RepositorioEmpleado {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEmpleadoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crearEmpleado(Empleado empleadoNuevo) {
        sessionFactory.getCurrentSession().save(empleadoNuevo);
    }

    @Override
    public Empleado buscarEmpleadoPorId(long id) {
        return sessionFactory.getCurrentSession()
                .get(Empleado.class, id);
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Empleado", Empleado.class)
                .getResultList();
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Long empleadoId) {
        return sessionFactory.getCurrentSession()
                .get(Empleado.class, empleadoId);
    }
}
