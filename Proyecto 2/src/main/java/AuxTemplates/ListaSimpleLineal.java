/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxTemplates;

import Exceptions.*;
/**
 *
 * @author xhunik
 */
public class ListaSimpleLineal {
    public NodoSimple ini;
    
    public String nombre;
    
    public ListaSimpleLineal(String nombre){
        this.nombre = nombre;
        ini = null;
    }
    public ListaSimpleLineal(){
        this("mi lista");
    }
    public void insertarAlFrente(Object dato){
        if (estaVacia())
            ini = new NodoSimple(dato);
        else
            ini = new NodoSimple(dato, ini);
    }
    
    public void insertarAlFinal(Object dato){
        if (estaVacia())
            ini = new NodoSimple(dato);
        else{
            NodoSimple act = ini;
            NodoSimple ant = null;
            do {
                ant = act;
                act = act.sig;
            }while (act != null);
            ant.sig = act = new NodoSimple(dato, null);
        }
        
    }
    
    public Object eliminarAlFrente() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Object datosAct = ini.dato;
        
        ini = ini.sig;
        
        return datosAct;
    }
    
    public Object eliminarAlFinal() throws ListaVaciaException {
        Object dato;
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        else {
            NodoSimple act = ini;
            NodoSimple ant = null;
            while (act.sig != null){
                ant = act;
                act = act.sig;
            }
            dato = act.dato;
            ant.sig = act = null;
            
        }
        return dato;
    }
    
    public boolean estaVacia(){
        return (ini == null);
    }

    public void imprimir(){
        if (estaVacia()){
            System.out.println("La lista: " + nombre + " esta vacia");
            return;
        }
        System.out.println("La lista: " + nombre);
        NodoSimple act = ini;
        
        while (act != null){
            try {
            System.out.println(act.dato + "->" + act.sig.dato);
            }
            catch (NullPointerException npe){
                System.out.println(act.dato + "-> null");
                //npe.printStackTrace();
            }
            finally{act = act.sig;}
        }
    }
    
}
