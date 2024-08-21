package com.example.ejemplo_clases.modelos;

import android.util.Log;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

public class Compra {

    public int numeroFactura;
    public LocalDateTime fechaHora;
    public ArrayList<DetalleCompra> listaProductos;
    public double subtotal;
    public double totalIva;
    public double descuento;
    public double valorTotal;
    public String metodoPago;
    public double pagaCon;
    public double cambio;

    public Compra(){
        this.numeroFactura = 0;
        this.fechaHora = LocalDateTime.now(); //fecha y hora actual
        this.subtotal = 0.0;
        this.totalIva = 0.0;
        this.descuento = 0.0;
        this.valorTotal = 0.0;
        this.metodoPago = "";
        this.pagaCon = 0.0;
        this.cambio = 0.0;
        this.listaProductos = new ArrayList<DetalleCompra>();
    }

    public void setNumeroFactura(int contador){
        this.numeroFactura = contador;
    }

    public String getNumeroFactura(){

        String cadena = "";

        for(int i = 4; i >= 0; i--){

            if(this.numeroFactura < Math.pow(10, i))
                cadena += "0";
            else {
                cadena += this.numeroFactura + "";
                break;
            }
        }

        return cadena;
    }

    public void agregarProducto( Producto p, int cantidad ){

        DetalleCompra dc;
        dc = new DetalleCompra();
        dc.cantidad =  cantidad;
        dc.descripcion = p.nombre;
        dc.vUnitario = p.precio;
        dc.vTotal = ( p.precio * dc.cantidad );

        dc.calcularSubtotal(p.porcentajeIva);
        dc.calcularIva(p.precio);

        listaProductos.add(dc);
    }

    public void calcularValoresCompra(double descuento){

        for (DetalleCompra item: listaProductos){

            this.subtotal += item.vUnitario;
            this.totalIva += item.iva;
            this.valorTotal += item.vTotal;
        }

        this.descuento = descuento;
        this.valorTotal = this.valorTotal * (1 - (this.descuento / 100)); // descuento %
    }

    public void calcularCambio(double pagaCon, String metodoPago){

        this.metodoPago = metodoPago;
        this.pagaCon = pagaCon;
        this.cambio = this.pagaCon - this.valorTotal;

    }

    public void mostrarCompra(){

        NumberFormat myFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        myFormat.setMaximumFractionDigits(2);

        Log.e("msg", "FACTURA DE VENTA");
        Log.e("msg", "No. " + getNumeroFactura());
        Log.e("msg", "----------------------------------------------------------------------------");
        Log.e("msg", "Cant.\t|\tDescripcion\t|\tV. Unitario\t\t|\t\tIVA\t\t|\tV. Total\t |");
        Log.e("msg", "----------------------------------------------------------------------------");

        for (DetalleCompra item: listaProductos){
            Log.e("msg", item.cantidad
                    + "\t\t| " + item.descripcion
                    + "\t| " + myFormat.format(item.vUnitario)
                    + "\t| " + myFormat.format(item.iva)
                    + "\t| " + myFormat.format(item.vTotal) + " |");
        }
        Log.e("msg", "----------------------------------------------------------------------------");

        Log.e("msg", "");
        Log.e("msg", "Subtotal:\t\t" + myFormat.format(this.subtotal));
        Log.e("msg", "IVA:\t\t\t" + myFormat.format(this.totalIva));
        Log.e("msg", "Descuento:\t\t" + this.descuento + "%");
        Log.e("msg", "Valor Total:\t" + myFormat.format(this.valorTotal));
        Log.e("msg", "");
        Log.e("msg", "M. de pago:\t" + this.metodoPago);
        Log.e("msg", "Paga con:\t\t" + myFormat.format(this.pagaCon));
        Log.e("msg", "Cambio:\t\t" + myFormat.format(this.cambio));

    }

}
