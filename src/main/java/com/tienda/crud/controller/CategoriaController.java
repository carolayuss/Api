package com.tienda.crud.controller;

import com.tienda.crud.Model.Categoria;
import com.tienda.crud.Model.Cliente;
import com.tienda.crud.Repository.CategoriaRepository;
import com.tienda.crud.Repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/categoria")

public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> obtenerProducto(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria obtenerCategoriaPorId (@PathVariable Long id) {
        Optional<Categoria> producto=categoriaRepository.findById(id);
        return Categoria.orElse(null);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria guardarCategoria(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    @PutMapping
    public Categoria actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarCategoria(@PathVariable Long id){
        categoriaRepository.deleteById(id);
    }
}


