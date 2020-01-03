/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.EspecNodos;

import Logica.Elements.Colaborador;

/**
 *
 * @author xhunik
 */
public class NodoColaboradorLD {
    public Colaborador dato;
    public NodoColaboradorLD sig;
    public NodoColaboradorLD ant;
    
    public NodoColaboradorLD(Colaborador dato, NodoColaboradorLD ant, NodoColaboradorLD sig){
        this.dato = dato;
        this.ant = ant;
        this.sig = sig;
    }
    public NodoColaboradorLD(Colaborador dato){
        this(dato,null,null);
    }
}
