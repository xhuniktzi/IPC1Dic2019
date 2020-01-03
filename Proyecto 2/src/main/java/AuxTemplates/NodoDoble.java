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
public class NodoDoble {
    public Object dato;
    public NodoDoble sig;
    public NodoDoble ant;
    
    public NodoDoble(Object dato, NodoDoble ant, NodoDoble sig){
        this.dato = dato;
        this.ant = ant;
        this.sig = sig;
    }
    public NodoDoble(Object dato){
        this(dato,null,null);
    }
}
