package com.tienda.crud.controller;

import com.tienda.crud.model.Cliente;
import com.tienda.crud.repository.ClienteRepository;
import jakarta.security.auth.message.AuthStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.AuthorizeRequestsDsl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.webauthn.api.AuthenticatorResponse;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.ScatteringByteChannel;
import java.security.AuthProvider;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        if (cliente.getContrasena() != null) {
            String passHashed = passwordEncoder.encode(cliente.getContrasena());
            cliente.setContrasena(passHashed);
        } else {
            throw new IllegalArgumentException("La contraseña no puede ser nula");
        }

        return clienteRepository.save(cliente);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Cliente> getClienteByCedula(@PathVariable String cedula) {
        return clienteRepository.findById(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody Cliente loginData) {
        Optional<Cliente> clienteOpt = clienteRepository.findByEmail(loginData.getEmail());
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            if (passwordEncoder.matches(loginData.getContrasena(), cliente.getContrasena())) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }
    }
}