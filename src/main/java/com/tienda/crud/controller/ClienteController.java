package com.tienda.crud.controller;

import com.tienda.crud.Model.Cliente;
import com.tienda.crud.Model.Promocion; // IMPORTAR Promocion
import com.tienda.crud.Repository.ClienteRepository;
import com.tienda.crud.Repository.PromocionRepository; // IMPORTAR PromocionRepository
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final PromocionRepository promocionRepository;  // Inyectar promocionRepository

    // Constructor para inyectar ambos repositorios
    public ClienteController(ClienteRepository clienteRepository, PromocionRepository promocionRepository) {
        this.clienteRepository = clienteRepository;
        this.promocionRepository = promocionRepository;
    }

    @GetMapping
    public List<Cliente> obtenerClientes(){  // Cambié nombre de método para que sea coherente
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        // Buscar la promoción del 50%
        Optional<Promocion> promo50Opt = promocionRepository.findByNombre("Bienvenida 50%");

        Promocion promo50;
        if (promo50Opt.isPresent()) {
            promo50 = promo50Opt.get();
        } else {
            // Si no existe, la creamos
            promo50 = new Promocion();
            promo50.setNombre("Bienvenida 50%");
            promo50.setDescripcion("Descuento del 50% por ser cliente nuevo");
            promo50.setTipo_descuento("porcentaje");
            promo50.setValor_descuento(50.0);
            promo50.setFecha_inicio(LocalDate.now());
            promo50.setFecha_fin(LocalDate.now().plusMonths(1)); // válido por 1 mes
            promocionRepository.save(promo50);
        }

        cliente.getPromociones().add(promo50);
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


