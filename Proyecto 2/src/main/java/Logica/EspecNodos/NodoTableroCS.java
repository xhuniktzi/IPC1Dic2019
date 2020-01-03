/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.EspecNodos;

import Logica.Elements.Tablero;

/**
 *
 * @author xhunik
 */
public class NodoTableroCS {
    public Tablero dato;
    public NodoTableroCS sig;

    public NodoTableroCS(Tablero dato){
        this.dato = dato;
        this.sig = this;
    }
}
