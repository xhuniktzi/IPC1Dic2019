/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.internal;

import com.xhunik.controladores.App;

/**
 *
 * @author xhunik
 */
public class Pedido {
    private int id;
    private ListaProducto listaProductosComprados;
    private boolean flag = true;
    //imagen <-

    public Pedido() {
        this.id = 0;
        this.flag = false;
        this.listaProductosComprados = new ListaProducto(1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListaProducto getListaProductosComprados() {
        return listaProductosComprados;
    }

    public void setListaProductosComprados(ListaProducto listaProductosComprados) {
        this.listaProductosComprados = listaProductosComprados;
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
    public void addNuevoProducto(Producto p){
        listaProductosComprados.addProducto(p);
    }
    
    public double calculatePrecioProducto(){
        double data = 0.0;
        for (int i = 0; i < listaProductosComprados.getSize(); i++){
            data += App.control.getGestor().getProductosDisponibles().searchProductoByID(listaProductosComprados.getProductoByIndex(i).getId()).getPrecio();
        }
        return data;
    }
    
    @Override
    public String toString() {
        String temporalStr;
        temporalStr = "Id: " + id + "\n";
        //temporalStr += "Productos comprados:\n";
        temporalStr += listaProductosComprados + "\n";
        return temporalStr;
    }
    
}
