package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioEmpleado")
public class ServicioEmpleadoImpl implements ServicioEmpleado {

    private RepositorioEmpleado repositorioEmpleado;

    @Autowired
    public ServicioEmpleadoImpl(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    @Override
    public void crearEmpleado(Empleado empleadoNuevo) {
        repositorioEmpleado.crearEmpleado(empleadoNuevo);
    }

    @Override
    public Empleado buscarEmpleadoPorId(long id) {
        return repositorioEmpleado.buscarEmpleadoPorId(id);
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        return repositorioEmpleado.obtenerTodosLosEmpleados();
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Long empleadoId) {
        return repositorioEmpleado.obtenerEmpleadoPorId(empleadoId);
    }
}
