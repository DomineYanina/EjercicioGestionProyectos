package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioEmpleado {
    void crearEmpleado(Empleado empleadoNuevo);

    Empleado buscarEmpleadoPorId(long id);

    List<Empleado> obtenerTodosLosEmpleados();

    Empleado obtenerEmpleadoPorId(Long empleadoId);
}
