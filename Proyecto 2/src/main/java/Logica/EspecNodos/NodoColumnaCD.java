/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.EspecNodos;

import Logica.Elements.Columna;

/**
 *
 * @author xhunik
 */
public class NodoColumnaCD {
    public Columna dato;
    public NodoColumnaCD sig;
    public NodoColumnaCD ant;
    
    public NodoColumnaCD(Columna dato, NodoColumnaCD ant, NodoColumnaCD sig){
        this.dato = dato;
        this.ant = ant;
        this.sig = sig;
    }
    public NodoColumnaCD(Columna dato){
        this(dato,null,null);
    }
}
