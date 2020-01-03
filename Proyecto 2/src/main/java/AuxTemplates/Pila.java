/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxTemplates;

import AuxTemplates.ListaSimpleLineal;
import Exceptions.ListaVaciaException;

/**
 *
 * @author xhunik
 */
public class Pila extends ListaSimpleLineal{

    public Pila(String nombre) {super(nombre);}
    
    public Object pop() throws ListaVaciaException{
        return super.eliminarAlFrente();
    }
    
    public void push(Object dato){super.insertarAlFrente(dato);}
    
    @Override
    public void imprimir(){super.imprimir();}
    
}
