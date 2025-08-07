package com.tienda.crud.controller;

import com.tienda.crud.model.Cliente;
import com.tienda.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

            // Comparar contraseña con hash almacenado
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



