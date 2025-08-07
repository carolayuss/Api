package com.tienda.crud.service;

import com.tienda.crud.model.Cliente;
import com.tienda.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;


    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }

    public Cliente registrarCliente(Cliente cliente) {
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("Correo ya existe");
        }

        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> autenticarCliente(String email, String rawPass) {
        return clienteRepository.findByEmail(email)
                .filter(c -> c.getContrasena().equals(rawPass));
    }
}

