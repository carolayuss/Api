package com.tienda.crud.Model;
import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String Imagen;


    public Producto() { 
    }

    public Producto(String imagen) {
        Imagen = imagen;
    }

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable=false)
    private Categoria categoria;

    public Producto(Long id_producto, String nombre, String descripcion, double precio, int stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;


    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) { this.Imagen = imagen; }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {

    }

    public void setId(Long id) {
    }
}

