package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioEmpleado {
    void crearEmpleado(Empleado empleadoNuevo);

    Empleado buscarEmpleadoPorId(long id);

    List<Empleado> obtenerTodosLosEmpleados();

    Empleado obtenerEmpleadoPorId(Long empleadoId);
}
