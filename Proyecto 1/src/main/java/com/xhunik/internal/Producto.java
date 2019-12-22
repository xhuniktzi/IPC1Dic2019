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
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String descripcion;
    private ListaInsumo insumosNecesarios;
    private boolean flag = true;
    private String pathImg;

    public Producto() {
        this.id = 0;
        this.nombre = "";
        this.precio = 0.0;
        this.descripcion = "";
        this.insumosNecesarios = new ListaInsumo((1));
        this.flag = false;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setInsumosNecesarios(ListaInsumo insumosNecesarios) {
        this.insumosNecesarios = insumosNecesarios;
    }

    public ListaInsumo getInsumosNecesarios() {
        return insumosNecesarios;
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
        temporalStr = "Id: " + id +" Nombre: " + nombre  + " Descripcion: " + descripcion + " Precio:"+ precio +"\n";
        /*
        temporalStr += "Insumos Necesarios:\n";
        for (int i = 0; i < insumosNecesarios.getSize()-1;i++){
            temporalStr += insumosNecesarios.getInsumoByIndex(i) + "\n";
        }
        */
        return temporalStr;
    }
    
}
