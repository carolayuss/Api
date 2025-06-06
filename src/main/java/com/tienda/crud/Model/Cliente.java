package com.tienda.crud.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nombre;

    private String email;

    private String telefono;

    private String direccion;

    public Cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Cliente(String direccion) {

    }

    @ManyToMany
    @JoinTable(
            name = "cliente_promocion",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "promocion_id")
    )
    private List<Promocion> promociones = new ArrayList<>();

    // Constructor vacío
    public Cliente() {}

    public Cliente(String nombre, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y setters

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public Long getId() {
        return id_cliente;
    }

    public void setId(Long id) {
        this.id_cliente= id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }
}


