package com.tallerwebi.dominio;

public interface ServicioCliente {
    Cliente obtenerClientePorId(Long clienteId);

    Cliente obtenerClientePorDNI(Long dni);
}
