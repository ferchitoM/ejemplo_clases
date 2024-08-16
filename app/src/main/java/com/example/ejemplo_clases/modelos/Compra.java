package com.example.ejemplo_clases.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Compra {

    public int numeroFactura;
    public LocalDateTime fechaHora;
    public ArrayList<DetalleCompra> detalleCompra;
    public double subtotal;
    public double totalIva;
    public double descuento;
    public double valorTotal;
    public double metodoPago;
    public double pagaCon;
    public double cambio;

    private Compra(){

    }

    private void agregarProducto(){

    }

    private void mostrarResumenCompra(){

    }

    private void mostrarCompra(){

    }

}
