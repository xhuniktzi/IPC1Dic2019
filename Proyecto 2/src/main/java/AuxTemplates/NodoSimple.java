/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxTemplates;

/**
 *
 * @author xhunik
 */
public class NodoSimple {
    public Object dato;
    public NodoSimple sig;
    
    public NodoSimple(Object dato,NodoSimple sig){
        this.dato = dato;
        this.sig = sig;
    }
    public NodoSimple(Object dato){
        this(dato,null);
    }
}
