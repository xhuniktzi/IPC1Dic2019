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
public class ListaCircularDoble {
    public NodoDoble ini;
    public NodoDoble end;
    public String nombre;
    
    public ListaCircularDoble(String nombre){
        ini = null;
        end = null;
        this.nombre = nombre;
    }
    public ListaCircularDoble(){
        this("mi Lista");
    }
    
    public void insertar(Object dato){
        NodoDoble nodo = new NodoDoble(dato);
        if (estaVacia()){
            ini = end = nodo;
            nodo.sig = nodo;
            nodo.ant = nodo;
        }
        else {
            end.sig = nodo;
            nodo.sig = ini;
            nodo.ant = end;
            end = nodo;
            ini.ant = end;
        }
        
    }
    
    public Object eliminar() throws ListaVaciaException{
        //NodoDoble act = ini;
        //NodoDoble ant = end;
        
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Object dato = ini.dato;
        ini = ini.sig;
        end.sig = ini;
        ini.ant = end;
        
        return dato;
        
    }
    
    public boolean estaVacia(){
        return (ini == null && end ==null);
    }
    
    public void imprimir(){
        if (estaVacia()){
            System.out.println("La lista. "+ nombre+ " esta vacia");
            return;
        }
        
        NodoDoble act = ini;
        do {
            System.out.println(act.ant.dato+"<-"+act.dato+"->"+act.sig.dato);
            act = act.sig;
        }  while (act!= ini);
    }
}
