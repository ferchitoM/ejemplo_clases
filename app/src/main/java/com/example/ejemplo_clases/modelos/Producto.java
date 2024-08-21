package com.example.ejemplo_clases.modelos;

import android.util.Log;

public class Producto {

    public String id;
    public String nombre;
    public double porcentajeIva;
    public double precio; //incluyendo el iva
    public int stock;
    public String codigo;
    public String imagen;

    public Producto(String nombre, double porcentajeIva, double precio, int stock, String codigo) {
        this.id = "";
        this.nombre = nombre;
        this.porcentajeIva = porcentajeIva;
        this.precio = precio;
        this.stock = stock;
        this.codigo = codigo;
        this.imagen = "";
    }
}
