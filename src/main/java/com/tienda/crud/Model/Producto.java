package com.tienda.crud.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String Accesorio;
    private String Description;
    private double Precio;


    //METODO CONSTRUCTOR
    public Producto(Long id, String accesorio, String description, double precio) {
        Id = id;
        Accesorio = accesorio;
        Description = description;
        Precio = precio;
    }
// METODO CONSTRUCTO SIN ARGUMENTOS
    public Producto() {
    }
// funciones de getters y seters llamadas con las propiedades exportadas al inicio del código
}
