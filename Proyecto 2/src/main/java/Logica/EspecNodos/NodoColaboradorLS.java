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
public class NodoColaboradorLS {
    public Colaborador dato;
    public NodoColaboradorLS sig;
    
    public NodoColaboradorLS(Colaborador dato,NodoColaboradorLS sig){
        this.dato = dato;
        this.sig = sig;
    }
    public NodoColaboradorLS(Colaborador dato){
        this(dato,null);
    }
}
