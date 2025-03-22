package com.tienda.crud.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;


@Setter
@Getter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_cliente;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String contraseña;

    public Cliente() {
    }

    public Cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public static Cliente orElse(Object o) {

        return null;
    }

    public void setId(Long id) {
    }
}

