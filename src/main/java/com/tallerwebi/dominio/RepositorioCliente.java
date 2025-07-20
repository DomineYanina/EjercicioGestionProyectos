package com.tallerwebi.dominio;

public interface RepositorioCliente {
    Cliente obtenerClientePorId(Long clienteId);

    Cliente obtenerClientePorDNI(Long dni);
}
