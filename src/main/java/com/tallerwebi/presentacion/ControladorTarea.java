package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ControladorTarea {

    private ServicioTarea servicioTarea;
    private ServicioProyecto servicioProyecto;
    private ServicioEmpleado servicioEmpleado;

    @Autowired
    public ControladorTarea(ServicioTarea servicioTarea, ServicioProyecto servicioProyecto, ServicioEmpleado servicioEmpleado) {
        this.servicioTarea = servicioTarea;
        this.servicioProyecto = servicioProyecto;
        this.servicioEmpleado = servicioEmpleado;
    }

    @GetMapping("/irACrearTarea")
    @Transactional
    public ModelAndView irACrearTarea() {
        ModelAndView mav = new ModelAndView("crearTarea");
        List<Proyecto> proyectos = servicioProyecto.obtenerTodosLosProyectos();
        mav.addObject("tarea", new TareaViewModel());
        mav.addObject("proyectos", proyectos);
        return mav;
    }

    @PostMapping("/crearTarea")
    @Transactional
    public ModelAndView crearTarea(@ModelAttribute("tarea") TareaViewModel tarea) {
        Tarea tareaNueva = new Tarea();
        tareaNueva.setNombre(tarea.getNombre());
        tareaNueva.setDescripcion(tarea.getDescripcion());
        tareaNueva.setEstado(tarea.getEstado());
        Proyecto proyectoSeleccionado = servicioProyecto.obtenerProyectoPorId(tarea.getProyecto());
        tareaNueva.setProyecto(proyectoSeleccionado);

        servicioTarea.crearTarea(tareaNueva);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/irAAsignarTarea")
    @Transactional
    public ModelAndView irAAsignarTarea() {
        ModelAndView mav = new ModelAndView("asignarTarea");
        List<Tarea> tareas = servicioTarea.obtenerTodasLasTareas();
        List<Empleado> empleados = servicioEmpleado.obtenerTodosLosEmpleados();
        mav.addObject("tareas", tareas);
        mav.addObject("empleados", empleados);
        return mav;
    }

    @PostMapping("/asignarTarea")
    @Transactional
    public ModelAndView asignarTarea(@RequestParam("tarea") Long tareaId,
                                     @RequestParam("empleado") Long empleadoId) {
        Tarea tarea = servicioTarea.obtenerTareaPorId(tareaId);
        Empleado empleado = servicioEmpleado.obtenerEmpleadoPorId(empleadoId);

        if (tarea != null && empleado != null) {
            tarea.setEmpleado(empleado);
            servicioTarea.actualizarTarea(tarea);
        }

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/eliminarTarea")
    @Transactional
    public ModelAndView eliminarTarea(@RequestParam("tareaId") Long tareaId) {
        Tarea tarea = servicioTarea.obtenerTareaPorId(tareaId);
        if (tarea != null) {
            servicioTarea.eliminarTarea(tarea);
        }
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/cambiarEstadoTarea")
    @Transactional
    public ModelAndView actualizarEstadoTarea(@RequestParam("tareaId") Long tareaId) {
        Tarea tarea = servicioTarea.obtenerTareaPorId(tareaId);
        if(tarea.getEstado()==EstadoTarea.Pendiente) {tarea.setEstado(EstadoTarea.En_Proceso);}
        if(tarea.getEstado()==EstadoTarea.En_Proceso) {tarea.setEstado(EstadoTarea.Terminada);}
        servicioTarea.actualizarTarea(tarea);

        return new ModelAndView("redirect:/home");
    }
}
