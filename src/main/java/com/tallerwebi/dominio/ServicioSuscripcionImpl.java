package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("servicioSuscripcion")
public class ServicioSuscripcionImpl implements ServicioSuscripcion {

    private final RepositorioSuscripcion repositorioSuscripcion;

    @Autowired
    public ServicioSuscripcionImpl(RepositorioSuscripcion repositorioSuscripcion) {
        this.repositorioSuscripcion = repositorioSuscripcion;
    }


    @Override
    public Suscripcion obtenerSuscripcionPorId(Long suscripcionId) {
        return repositorioSuscripcion.obtenerSuscripcionPorId(suscripcionId);
    }

    @Override
    public List<Cliente> obtenerClientesPorSuscripcion(Long suscripcionId) {
        return repositorioSuscripcion.obtenerClientesPorSuscripcion(suscripcionId);
    }

    @Override
    public void actualizarSuscripcion(Suscripcion suscripcion) {
        repositorioSuscripcion.actualizarSuscripcion(suscripcion);
    }

    @Override
    public List<Suscripcion> obtenerTodasSuscripciones() {
        return repositorioSuscripcion.obtenerTodasSuscripciones();
    }

    @Override
    public List<Cliente> obtenerClientesPorTipoSuscripcion(TipoSuscripcion tipoSuscripcion) {
        return repositorioSuscripcion.obtenerClientesPorTipoSuscripcion(tipoSuscripcion);
    }
}
