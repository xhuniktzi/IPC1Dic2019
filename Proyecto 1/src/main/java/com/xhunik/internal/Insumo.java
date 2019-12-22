/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.internal;

/**
 *
 * @author xhunik
 */
public class Insumo {
    private int id;
    private String nombre;
    private int cantidad;
    private int cantidadMinima;
    private int cantidadMaxima;
    private double costo;
    private String descripcion;
    private boolean flag = true;
    private String pathImg;

    public Insumo() {
        this.id = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.cantidadMinima = 0;
        this.cantidadMaxima = 0;
        this.costo = 0.0;
        this.descripcion = "";
        this.flag = false;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public double getCosto() {
        return costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }
    
    @Override
    public String toString() {
        String temporalStr;
        temporalStr = "Id: " + id +" Nombre: " + nombre + " Cantidad: "+ cantidad + " Max: " + cantidadMaxima + " Min:" + cantidadMinima + " Costo:" + costo + " Descripcion: " + descripcion + "\n";
        return temporalStr;
    }
    
}
