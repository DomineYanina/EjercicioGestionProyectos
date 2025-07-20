package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ServicioSuscripcion {
    Suscripcion obtenerSuscripcionPorId(Long suscripcionId);

    List<Cliente> obtenerClientesPorSuscripcion(Long suscripcionId);

    void actualizarSuscripcion(Suscripcion suscripcion);

    List<Suscripcion> obtenerTodasSuscripciones();

    List<Cliente> obtenerClientesPorTipoSuscripcion(TipoSuscripcion tipoSuscripcion);
}
