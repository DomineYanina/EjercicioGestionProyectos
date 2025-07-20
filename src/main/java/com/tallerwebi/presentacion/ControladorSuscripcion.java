package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ControladorSuscripcion {

    private ServicioSuscripcion servicioSuscripcion;
    private ServicioCliente servicioCLiente;

    @Autowired
    public ControladorSuscripcion(ServicioSuscripcion servicioSuscripcion,
                                  ServicioCliente servicioCliente) {
        this.servicioSuscripcion = servicioSuscripcion;
        this.servicioCLiente = servicioCliente;
    }

    @GetMapping("/irAVerHistorial")
    public ModelAndView irAVerHistorial() {
        ModelAndView modelAndView = new ModelAndView("historial");

        List<Cliente> clientesBasicos = servicioSuscripcion.obtenerClientesPorTipoSuscripcion(TipoSuscripcion.Basica);
        List<Cliente> clientesPremium = servicioSuscripcion.obtenerClientesPorTipoSuscripcion(TipoSuscripcion.Premium);

        modelAndView.addObject("clientesBasicos", clientesBasicos);
        modelAndView.addObject("clientesPremium", clientesPremium);
        return modelAndView;
    }

    @PostMapping("/quitarClienteDeSuscripcion")
    @Transactional
    public ModelAndView quitarClienteDeSuscripcion(Long clienteDNI, Long suscripcionId) {
        ModelAndView modelAndView = new ModelAndView("historial");

        Suscripcion suscripcion = servicioSuscripcion.obtenerSuscripcionPorId(suscripcionId);
        Cliente cliente = servicioCLiente.obtenerClientePorDNI(clienteDNI);

        if(suscripcion != null && cliente != null) {
            List<Cliente> clientes = servicioSuscripcion.obtenerClientesPorSuscripcion(suscripcionId);
            if(clientes.contains(cliente)) {
                suscripcion.quitarCliente(cliente);
                servicioSuscripcion.actualizarSuscripcion(suscripcion);

                List<Cliente> clientesBasicos = servicioSuscripcion.obtenerClientesPorTipoSuscripcion(TipoSuscripcion.Basica);
                List<Cliente> clientesPremium = servicioSuscripcion.obtenerClientesPorTipoSuscripcion(TipoSuscripcion.Premium);

                modelAndView.addObject("clientesBasicos", clientesBasicos);
                modelAndView.addObject("clientesPremium", clientesPremium);

                modelAndView.addObject("mensaje", "Cliente quitado de la suscripción correctamente.");
            } else {
                modelAndView.addObject("mensaje", "El cliente no se encuentra en la suscripción.");
            }
        }
        return modelAndView;
    }

    @GetMapping("/irASeleccionarSuscripcion")
    public ModelAndView irASeleccionarSuscripcion() {
        ModelAndView modelAndView = new ModelAndView("seleccionarSuscripcion");
        List<Suscripcion> suscripciones = servicioSuscripcion.obtenerTodasSuscripciones();
        modelAndView.addObject("suscripciones", suscripciones);
        return modelAndView;
    }

    @PostMapping("/agregarClienteASuscripcion")
    @Transactional
    public ModelAndView agregarClienteASuscripcion(Long clienteDNI, Long suscripcionId) {

        ModelAndView modelAndView = new ModelAndView("seleccionarSuscripcion");

        Suscripcion suscripcion = servicioSuscripcion.obtenerSuscripcionPorId(suscripcionId);
        Cliente cliente = servicioCLiente.obtenerClientePorDNI(clienteDNI);

        if(suscripcion != null && cliente != null) {
            List<Cliente> clientes = servicioSuscripcion.obtenerClientesPorSuscripcion(suscripcionId);
            if(!clientes.contains(cliente)) {
                suscripcion.agregarCliente(cliente);
                servicioSuscripcion.actualizarSuscripcion(suscripcion);

                modelAndView.addObject("mensaje", "Cliente agregado a la suscripción correctamente.");
            } else {
                modelAndView.addObject("mensaje", "El cliente ya se encuentra suscrito.");
            }
        }
        else
        {
            if(cliente == null) {
                Cliente nuevoCLiente = new Cliente();
                nuevoCLiente.setDNI(clienteDNI);
                nuevoCLiente.setNombre("Nuevo Cliente");
                nuevoCLiente.setSuscripcion(suscripcion);
                suscripcion.agregarCliente(nuevoCLiente);
                servicioSuscripcion.actualizarSuscripcion(suscripcion);
            }
        }

        return modelAndView;
    }


}
