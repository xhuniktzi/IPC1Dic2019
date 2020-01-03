/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxTemplates;

import AuxTemplates.ListaSimpleLineal;


/**
 *
 * @author xhunik
 */
public class Cola extends ListaSimpleLineal{

    public Cola(String nombre) {super(nombre);}
    
    public void enqueue(Object dato){super.insertarAlFinal(dato);}
    
    public Object dequeue(){return super.eliminarAlFrente();}

    @Override
    public void imprimir(){super.imprimir();}
}
