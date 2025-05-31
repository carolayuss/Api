package com.tienda.crud.controller;

import com.tienda.crud.Model.Producto;
import com.tienda.crud.Model.Promocion;
import com.tienda.crud.Repository.ProductoRepository;
import com.tienda.crud.Repository.PromocionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/api/producto")

public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<Producto> obtenerProducto(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId (@PathVariable Long id) {
        Optional<Producto> producto=productoRepository.findById(id);
        return producto.orElse(null);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarProductp(@PathVariable Long id){
        productoRepository.deleteById(id);
    }

}
