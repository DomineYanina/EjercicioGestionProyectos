package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioCliente")
public class ServicioClienteImpl implements ServicioCliente {

    private RepositorioCliente repositorioCliente;

    @Autowired
    public ServicioClienteImpl(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    @Override
    public Cliente obtenerClientePorId(Long clienteId) {
        return repositorioCliente.obtenerClientePorId(clienteId);
    }

    @Override
    public Cliente obtenerClientePorDNI(Long dni) {
        return repositorioCliente.obtenerClientePorDNI(dni);
    }
}
