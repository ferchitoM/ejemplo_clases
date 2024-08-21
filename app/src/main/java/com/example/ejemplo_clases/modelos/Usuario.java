package com.example.ejemplo_clases.modelos;

import java.util.ArrayList;

public class Usuario {

    public String nombre;
    public Long documentoIdentidad;
    public String correo;
    public String contraseña;
    public String fotoPerfil;
    public ArrayList<Compra> compras;

    public Usuario(){
        this.nombre = "";
        this.documentoIdentidad = 0L;
        this.correo = "";
        this.contraseña = "";
        this.fotoPerfil = "";
        this.compras = new ArrayList<Compra>();
    }

    private void agregarCompra(){

    }

    private void listarCompras(){

    }

}
