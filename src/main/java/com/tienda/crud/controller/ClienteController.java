package com.tienda.crud.controller;

import com.tienda.crud.Model.Cliente;
import com.tienda.crud.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Cliente> getClienteByCedula(@PathVariable String cedula) {
        return clienteRepository.findById(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Nuevo endpoint para login
    @PostMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody Cliente loginData) {
        Optional<Cliente> clienteOpt = clienteRepository.findByEmail(loginData.getEmail());

        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            if (cliente.getContrasena().equals(loginData.getContrasena())) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }
    }
}



