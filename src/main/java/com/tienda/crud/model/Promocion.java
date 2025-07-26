package com.tienda.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_promocion;

    private String nombre;
    private String descripcion;
    private String tipo_descuento; // Ej: "porcentaje"
    private Double valor_descuento; // Ej: 50.0

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    @ManyToMany(mappedBy = "promociones")
    @JsonIgnore
    private List<Cliente> clientes = new ArrayList<>();

    // === Constructores ===

    public Promocion() {
    }

    public Promocion(String nombre, String descripcion, String tipo_descuento, Double valor_descuento,
                     LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo_descuento = tipo_descuento;
        this.valor_descuento = valor_descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    // === Getters y Setters ===

    public Long getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(Long id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_descuento() {
        return tipo_descuento;
    }

    public void setTipo_descuento(String tipo_descuento) {
        this.tipo_descuento = tipo_descuento;
    }

    public Double getValor_descuento() {
        return valor_descuento;
    }

    public void setValor_descuento(Double valor_descuento) {
        this.valor_descuento = valor_descuento;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}







