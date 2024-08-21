package com.example.ejemplo_clases.modelos;

public class DetalleCompra {

    public int cantidad;
    public String descripcion;
    public double vUnitario;
    public double iva;
    public double vTotal;

    public DetalleCompra(){
        this.cantidad = 0;
        this.descripcion = "";
        this.vUnitario = 0.0;
        this.iva = 0.0;
        this.vTotal = 0.0;
    }

    public void calcularSubtotal(double porcentajeIva){

        double precio = this.vUnitario;
        this.vUnitario = precio / (1 + (porcentajeIva / 100));

    }

    public void calcularIva(double precio){

        this.iva = precio - this.vUnitario;
    }
}