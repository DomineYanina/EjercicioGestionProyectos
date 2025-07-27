package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Proyecto;
import com.tallerwebi.dominio.ServicioProyecto;
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
public class ControladorProyecto {

    private ServicioProyecto servicioProyecto;

    @Autowired
    public ControladorProyecto(ServicioProyecto servicioProyecto) {
        this.servicioProyecto = servicioProyecto;
    }

    @GetMapping("/home")
    public ModelAndView irAHome() {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @GetMapping("/irACrearProyecto")
    public ModelAndView irACrearProyecto() {
        ModelAndView mav = new ModelAndView("crearProyecto");
        mav.addObject("proyecto", new ProyectoViewModel());
        return mav;
    }

    @PostMapping("/crearProyecto")
    @Transactional
    public ModelAndView crearProyecto(@ModelAttribute("proyecto") ProyectoViewModel proyecto) {
        Proyecto proyectoCreado = new Proyecto();
        proyectoCreado.setNombre(proyecto.getNombre());
        proyectoCreado.setDescripcion(proyecto.getDescripcion());
        proyectoCreado.setTipo(proyecto.getTipo());

        servicioProyecto.crearProyecto(proyectoCreado);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/eliminarProyecto")
    @Transactional
    public ModelAndView eliminarProyecto(@RequestParam("proyectoId") Long proyectoId) {
        Proyecto proyecto = servicioProyecto.obtenerProyectoPorId(proyectoId);
        if (proyecto == null) {
            return new ModelAndView("redirect:/home?error=Proyecto no encontrado");
        }
        servicioProyecto.eliminarProyecto(proyecto);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/irAHistorial")
    @Transactional
    public ModelAndView irAHistorial() {
        ModelAndView mav = new ModelAndView("historialProyectos");
        List<Proyecto> proyectosDesarrollo = servicioProyecto.obtenerTodosLosProyectosDesarrollo();
        List<Proyecto> proyectosMarketing = servicioProyecto.obtenerTodosLosProyectosMarketing();
        List<Proyecto> proyectosInvestigacion = servicioProyecto.obtenerTodosLosProyectosInvestigacion();

        mav.addObject("proyectosDesarrollo", proyectosDesarrollo);
        mav.addObject("proyectosMarketing", proyectosMarketing);
        mav.addObject("proyectosInvestigacion", proyectosInvestigacion);
        return mav;
    }

    @GetMapping("/consultarTareasPorProyecto")
    @Transactional
    public ModelAndView consultarTareasPorProyecto(@RequestParam("proyectoId") Long proyectoId) {
        Proyecto proyecto = servicioProyecto.obtenerProyectoPorId(proyectoId);
        ModelAndView mav = new ModelAndView("historialProyectos");
        // Vuelve a cargar los proyectos para los filtros y el select
        mav.addObject("proyectosDesarrollo", servicioProyecto.obtenerTodosLosProyectosDesarrollo());
        mav.addObject("proyectosMarketing", servicioProyecto.obtenerTodosLosProyectosMarketing());
        mav.addObject("proyectosInvestigacion", servicioProyecto.obtenerTodosLosProyectosInvestigacion());
        if (proyecto != null) {
            mav.addObject("tareasPorProyecto", proyecto.getTareas());
        }
        return mav;
    }

}
