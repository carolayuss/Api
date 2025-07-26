package com.tienda.crud.controller;

import com.tienda.crud.model.Promocion;
import com.tienda.crud.repository.PromocionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promocion")
@CrossOrigin(origins = "http://localhost:3000")
public class PromocionController {

    private final PromocionRepository promocionRepository;


    public PromocionController(PromocionRepository promocionRepository) {
        this.promocionRepository = promocionRepository;
    }

    @GetMapping
    public List<Promocion> obtenerPromocion() {
        return promocionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Promocion obtenerPromocionPorId(@PathVariable Long id) {
        Optional<Promocion> promocion = promocionRepository.findById(id);
        return promocion.orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Promocion guardarPromocion(@RequestBody Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPromocion(@PathVariable Long id) {
        promocionRepository.deleteById(id);
    }
}

