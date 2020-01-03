/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxTemplates;

import Exceptions.ListaVaciaException;

/**
 *
 * @author xhunik
 */
public class ListaCircularSimple {
    NodoCircularSimple end;
    String nombre;
    public ListaCircularSimple(String nombre){
        this.nombre = nombre;
        end = null;
    }
    public ListaCircularSimple(){this("mi Lista");}
    
    public boolean estaVacia(){
        return (end == null);
    }
    public void insertar(Object dato){
        NodoCircularSimple nodo = new NodoCircularSimple(dato);
        if (end != null){
            nodo.sig = end.sig;
            end.sig = nodo;
        }
        else
            end = nodo;
    }
    
    public Object eliminar() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        NodoCircularSimple act = end;
        NodoCircularSimple aux = act.sig;
        Object dato = aux.dato;
        if (end == end.sig)
            end = null;
        else{
            if  (aux == end)
                end = act;
        
            act.sig = aux.sig;
        }
        return dato;
    }
    public void imprimir(){
        
        if (estaVacia())
        {
            System.out.println("La lista: " + nombre + " esta vacia");
            return;
        }
        NodoCircularSimple act = end.sig;
        do{
            System.out.println(act.dato + "->" + act.sig.dato);
            act = act.sig;
        }while (act != end.sig);
    }
}
