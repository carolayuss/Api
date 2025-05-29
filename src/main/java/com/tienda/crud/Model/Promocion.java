package com.tienda.crud.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_promocion;
    private String nombre;
    private Double descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Promocion() {
    }

    @ManyToMany
    @JoinTable(
            name = "promocion_cliente",
            joinColumns = @JoinColumn(name = "id_promocion"),
            inverseJoinColumns = @JoinColumn (name = "id_cliente"))
    private List<Cliente> clienteList;

    public Promocion(Long id_promocion, String nombre, Double descuento, LocalDate fechaInicio, LocalDate fechaFin, List<Cliente> clienteList) {
        this.id_promocion = id_promocion;
        this.nombre = nombre;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.clienteList = clienteList;
    }

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

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {

    }

    public void setId(Long id) {
    }
}


