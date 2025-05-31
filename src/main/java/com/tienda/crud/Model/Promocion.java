package com.tienda.crud.Model;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_promocion;
    private String nombre;
    private String descripcion;
    private double tipo_descuento;
    private double valor_descuento;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Promocion(Long id_promocion, String nombre, String descripcion, double tipo_descuento, double valor_descuento, Date fecha_inicio, Date fecha_fin) {
        this.id_promocion = id_promocion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo_descuento = tipo_descuento;
        this.valor_descuento = valor_descuento;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTipo_descuento() {
        return tipo_descuento;
    }

    public void setTipo_descuento(double tipo_descuento) {
        this.tipo_descuento = tipo_descuento;
    }

    public double getValor_descuento() {
        return valor_descuento;
    }

    public void setValor_descuento(double valor_descuento) {
        this.valor_descuento = valor_descuento;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setId(Long id) {
    }
}



