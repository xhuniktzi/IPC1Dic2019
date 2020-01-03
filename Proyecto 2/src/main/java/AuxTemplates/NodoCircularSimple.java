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
public class NodoCircularSimple {
    public Object dato;
    public NodoCircularSimple sig;

    public NodoCircularSimple(Object dato){
        this.dato = dato;
        this.sig = this;
    }
}
