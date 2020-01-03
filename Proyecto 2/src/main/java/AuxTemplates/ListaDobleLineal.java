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
public class ListaDobleLineal {
    public NodoDoble ini;
    public NodoDoble end;
    public String nombre;
    
    public ListaDobleLineal(String nombre){
        this.nombre = nombre;
        ini = end = null;
    }
    
    public ListaDobleLineal(){
        this("mi lista");
    }
    public void insertarAlFrente(Object dato){
        if (estaVacia())
            ini = end = new NodoDoble(dato);
        else
            ini = ini.ant = new NodoDoble(dato, null, ini);
    }
    
    public void insertarAlFinal(Object dato){
        if (estaVacia())
            ini = end = new NodoDoble(dato);
        else
            end = end.sig = new NodoDoble(dato, end, null);
    }
    
    public Object eliminarAlFrente() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Object datosAct = ini.dato;
        
        if (ini == end)
            ini = end = null;
        else{
            ini = ini.sig;
            ini.ant = null;
        }
        return datosAct;
    }
    
    public Object eliminarAlFinal(){
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Object datosAct = end.dato;
        
        if (ini == end)
            ini = end = null;
        else {
            end = end.ant;
            end.sig = null;
        }
        return datosAct;
    }
    
    public boolean estaVacia(){
        return (ini == null && end == null);
    }

    public void imprimir(){
        if (estaVacia()){
            System.out.println("La lista: " + nombre + " esta vacia");
            return;
        }
        System.out.println("La lista: " + nombre);
        NodoDoble act = ini;
        
        while (act != null){
            try{
                System.out.println(act.ant.dato + "<-"+ act.dato + "->" + act.sig.dato);
            }
            catch (NullPointerException npe){
                if (act.ant == null && act.sig == null){
                    System.out.println("null <-"+ act.dato + "-> null");
                    continue;
                }
                if (act.ant == null){
                    System.out.println("null <-"+ act.dato + "->" + act.sig.dato);
                    continue;
                }
                if (act.sig == null){
                    System.out.println(act.ant.dato + "<-"+ act.dato + "-> null");    
                    continue;
                }
                //npe.printStackTrace();
            }
            finally {act = act.sig;}
        }
    }
}