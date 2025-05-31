package com.tienda.crud.controller;

import com.tienda.crud.Model.Cliente;
import com.tienda.crud.Model.Producto;
import com.tienda.crud.Repository.ClienteRepository;
import com.tienda.crud.Repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/cliente")

public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> obtenerProducto(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId (@PathVariable Long id) {
        Optional<Cliente> producto=clienteRepository.findById(id);
        return Cliente.orElse(null);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCliente(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }
}

