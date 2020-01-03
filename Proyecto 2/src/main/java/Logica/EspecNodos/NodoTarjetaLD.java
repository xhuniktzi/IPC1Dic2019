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
public class NodoTarjetaLD {
    public Tarjeta dato;
    public NodoTarjetaLD sig;
    public NodoTarjetaLD ant;
    
    public NodoTarjetaLD(Tarjeta dato, NodoTarjetaLD ant, NodoTarjetaLD sig){
        this.dato = dato;
        this.ant = ant;
        this.sig = sig;
    }
    public NodoTarjetaLD(Tarjeta dato){
        this(dato,null,null);
    }
}
