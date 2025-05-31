package com.tienda.crud.controller;

import com.tienda.crud.Model.Cliente;
import com.tienda.crud.Model.Promocion;
import com.tienda.crud.Repository.ClienteRepository;
import com.tienda.crud.Repository.PromocionRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promocion")
public class PromocionController {

    private final PromocionRepository promocionRepository;
    private final ClienteRepository clienteRepository;

    public PromocionController(PromocionRepository promocionRepository, ClienteRepository clienteRepository) {
        this.promocionRepository = promocionRepository;
        this.clienteRepository = clienteRepository;
    }


    @GetMapping
    public List<Promocion> obtenerPromocion(){
        return promocionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Promocion obtenerPromocionPorId (@PathVariable Long id) {
        Optional<Promocion> promocion=promocionRepository.findById(id);
        return promocion.orElse(null);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Promocion guardarPromocion(@RequestBody Promocion promocion){
        return promocionRepository.save(promocion);
    }
    @PutMapping("/{idCliente}/promocion/{idPromocion}")
    public ResponseEntity<?> agregarPromocionACliente(@PathVariable Long idCliente, @PathVariable Long idPromocion) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
        Optional<Promocion> promoOpt = promocionRepository.findById(idPromocion);

        if (clienteOpt.isPresent() && promoOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            Promocion promocion = promoOpt.get();

            cliente.getPromociones().add(promocion);
            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPromocion(@PathVariable Long id){
        promocionRepository.deleteById(id);
    }
}

