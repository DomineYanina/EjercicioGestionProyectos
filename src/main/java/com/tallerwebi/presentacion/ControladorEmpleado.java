package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Empleado;
import com.tallerwebi.dominio.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
public class ControladorEmpleado {

    private ServicioEmpleado servicioEmpleado;

    @Autowired
    public ControladorEmpleado(ServicioEmpleado servicioEmpleado) {
        this.servicioEmpleado = servicioEmpleado;
    }

    @GetMapping("/irACrearEmpleado")
    public ModelAndView irACrearEmpleado() {
        ModelAndView mav = new ModelAndView("crearEmpleado");
        mav.addObject("empleado", new EmpleadoViewModel());
        return mav;
    }

    @PostMapping("/crearEmpleado")
    @Transactional
    public ModelAndView crearEmpleado(@ModelAttribute("empleado") EmpleadoViewModel empleado) {
        Empleado empleadoNuevo = new Empleado();
        empleadoNuevo.setNombre(empleado.getNombre());
        empleadoNuevo.setRol(empleado.getRol());
        servicioEmpleado.crearEmpleado(empleadoNuevo);

        return new ModelAndView("redirect:/home");
    }
}
