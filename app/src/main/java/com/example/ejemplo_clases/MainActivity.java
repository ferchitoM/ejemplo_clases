package com.example.ejemplo_clases;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejemplo_clases.modelos.Compra;
import com.example.ejemplo_clases.modelos.Producto;
import com.example.ejemplo_clases.modelos.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Producto> productosBD;

    public Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarProductos();

        //Registramos un nuevo usuario
        usuario = new Usuario();
        usuario.nombre = "Juan Pérez";

        int contadorCompras = usuario.compras.size(); //Tamaño de la lista de compras

        //Registramos la compra 1
        Compra c1;
        c1 = new Compra();
        c1.setNumeroFactura( contadorCompras + 1 );
        c1.agregarProducto(productosBD.get(0), 1); //Agregar 1 "Portátil A"
        c1.agregarProducto(productosBD.get(1), 1); //Agregar 1 "Portátil B"
        c1.calcularValoresCompra(2.5); //2.5% de descuento
        c1.calcularCambio(4000000, "Efectivo");
        c1.mostrarCompra();

    }

    private void cargarProductos() {

        productosBD = new ArrayList<Producto>();
        //El precio de los productos tiene el iva incluido
        productosBD.add( new Producto("Portátil A", 19, 2000000, 10, "ABCD123"));
        productosBD.add( new Producto("Portátil B", 19, 2000000, 8, "EFGH456"));
        productosBD.add( new Producto("Portátil C", 16, 1500000, 20, "IJKL789"));

    }
}