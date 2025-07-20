package com.tallerwebi.dominio;

import java.util.List;

public interface RepositorioSuscripcion {
    Suscripcion obtenerSuscripcionPorId(Long suscripcionId);

    List<Cliente> obtenerClientesPorSuscripcion(Long suscripcionId);

    void actualizarSuscripcion(Suscripcion suscripcion);

    List<Suscripcion> obtenerTodasSuscripciones();

    List<Cliente> obtenerClientesPorTipoSuscripcion(TipoSuscripcion tipoSuscripcion);
}
