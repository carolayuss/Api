package com.tienda.crud.Model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDescuento;

    private Double valorDescuento;

    @ManyToMany(mappedBy = "promociones")
    private List<Cliente> clientes = new ArrayList<>();

    // ⚠️ Constructor vacío requerido por JPA
    public Promocion() {}

    // ✔️ Constructor útil adicional si quieres crear promociones desde código
    public Promocion(String tipoDescuento, Double valorDescuento) {
        this.tipoDescuento = tipoDescuento;
        this.valorDescuento = valorDescuento;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}




