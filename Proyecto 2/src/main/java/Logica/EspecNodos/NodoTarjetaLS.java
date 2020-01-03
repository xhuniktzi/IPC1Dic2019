/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.EspecNodos;

import Logica.Elements.Tarjeta;

/**
 *
 * @author xhunik
 */
public class NodoTarjetaLS {
    public Tarjeta dato;
    public NodoTarjetaLS sig;
    
    public NodoTarjetaLS(Tarjeta dato,NodoTarjetaLS sig){
        this.dato = dato;
        this.sig = sig;
    }
    public NodoTarjetaLS(Tarjeta dato){
        this(dato,null);
    }
}
