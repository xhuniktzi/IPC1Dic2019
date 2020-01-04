/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;


import Exceptions.InvalidTitleCardException;
import Exceptions.ListaVaciaException;
import Exceptions.TarjetaNotFoundException;

import Logica.Elements.Tarjeta;
import Logica.EspecNodos.NodoTarjetaLS;

/**
 *
 * @author xhunik
 */
public class TarjetasLS {
    public NodoTarjetaLS ini;
    public int contador;
    public String nombre;
    
    public TarjetasLS(String nombre){
        this.nombre = nombre;
        contador = 0;
        ini = null;
    }
    public TarjetasLS(){
        this("mi lista");
    }
    public void insertarAlFrente(Tarjeta dato) throws InvalidTitleCardException {
        if(checkExistsTitle(dato.title))
            throw new InvalidTitleCardException();
        
        
        if (estaVacia())
            ini = new NodoTarjetaLS(dato);
        else
            ini = new NodoTarjetaLS(dato, ini);
        
        contador++;
    }
    
    public void insertarAlFinal(Tarjeta dato) throws InvalidTitleCardException {
        if(checkExistsTitle(dato.title))
            throw new InvalidTitleCardException();
        
        
        if (estaVacia())
            ini = new NodoTarjetaLS(dato);
        else{
            NodoTarjetaLS act = ini;
            NodoTarjetaLS ant = null;
            do {
                ant = act;
                act = act.sig;
            }while (act != null);
            ant.sig = act = new NodoTarjetaLS(dato, null);
            contador++;
        }
        
    }
    
    public boolean checkExistsTitle(String title){
        NodoTarjetaLS act = ini;
        while (act != null){
            if (act.dato.title.equals(title) )
                return true;
            act = act.sig;
        }
        return false;
    }
    public Tarjeta eliminarAlFrente() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Tarjeta datosAct = ini.dato;
        
        ini = ini.sig;
        contador--;
        return datosAct;
    }
    
    public Tarjeta eliminarAlFinal() throws ListaVaciaException {
        Tarjeta dato;
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        else {
            NodoTarjetaLS act = ini;
            NodoTarjetaLS ant = null;
            while (act.sig != null){
                ant = act;
                act = act.sig;
            }
            dato = act.dato;
            ant.sig = act = null;
            
        }
        contador--;
        return dato;
    }
     public Tarjeta getTarjetaByTitle(String title) throws ListaVaciaException, TarjetaNotFoundException {
        if (estaVacia()) 
            throw new ListaVaciaException(nombre);
         
        NodoTarjetaLS act = ini;
        while (act != null){
            if (act.dato.title.equals(title) )
                return act.dato;
            act = act.sig;
        }
        throw new TarjetaNotFoundException();
    }
    
    public boolean estaVacia(){
        return (ini == null);
    }

    public Tarjeta[] getArrayTarjeta() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Tarjeta[] retorno = new Tarjeta[contador];
        int i = 0;
        NodoTarjetaLS act = ini;
        while (act != null){
            retorno[i] = act.dato;
            act = act.sig;
            i++;
        }
        return retorno;
    }
    
    public void imprimir(){
        if (estaVacia()){
            System.out.println("La lista: " + nombre + " esta vacia");
            return;
        }
        System.out.println("La lista: " + nombre);
        NodoTarjetaLS act = ini;
        
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
