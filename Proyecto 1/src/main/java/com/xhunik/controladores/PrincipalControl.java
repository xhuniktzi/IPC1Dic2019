/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.controladores;

import com.xhunik.internal.Gestor;
import com.xhunik.internal.ListaInsumo;

import com.xhunik.internal.ListaProducto;

/**
 *
 * @author xhunik
 */
public class PrincipalControl {
    private Gestor gestor;
    private double dinero;
    
    
    public PrincipalControl(){
        gestor = new Gestor();
        dinero = 0.0;
    }
    public boolean executeSellById(int id){
        if (gestor.checkoutProductoById(id)){
            dinero += gestor.calculateVentaByIdproducto(id);
            System.out.println(dinero);
            return true;
        }
        
        return false;
    }
    public void executeReabastecerInsumos(int id){
        if (gestor.calculateCostoReabastecerInsumo(id) > 0){
            dinero -= gestor.calculateCostoReabastecerInsumo(id);
            gestor.executeReabastecerInsumo(id);
            System.out.println(dinero);
        }
    }
    public void executeRegisterNewInsumo(String n,int cant ,int max,int min,double c , String desc){
        System.out.println(gestor.getInventario());
        gestor.RegisterNewInsumo(n, cant, max, min, c, desc);
    }
    public ListaProducto obtainsIdProductoByNombre(String n){
        return gestor.getProductosDisponibles().searchProductosByNombre(n);
    }

    public Gestor getGestor() {
        return gestor;
    }
    public void executeRegisterNuevoProducto(String n, ListaInsumo list, double precio,String desc){
        gestor.RegisterNewProducto(n, list, precio, desc);
    }

    public double getDinero() {
        return dinero;
    }
    
}
