package com.tienda.crud.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes") // El nombre de tu tabla en la BD
public class Cliente {

    @Id
    private String cedula; // Cambiado a String para la cédula

    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String contrasena; // Corregido de 'contraseña'
    @Transient
    private String confirmarContrasena;

    // --- CONSTRUCTORES ---

    public Cliente() {}
    public Cliente(String cedula) {
        this.cedula = cedula;
    }

    public Cliente(String cedula, String nombre, String email, String telefono, String direccion, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "cliente_promocion",
            joinColumns = @JoinColumn(name = "cliente_cedula"), // ¡Importante cambiar esto!
            inverseJoinColumns = @JoinColumn(name = "promocion_id")
    )
    private List<Promocion> promociones = new ArrayList<>();

    // --- GETTERS Y SETTERS ---

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmarContrasena() {
        return confirmarContrasena;
    }

    public void setConfirmarContrasena(String confirmarContrasena) {
        this.confirmarContrasena = confirmarContrasena;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(List<Promocion> promociones) {
        this.promociones = promociones;
    }
}


