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
import Logica.EspecNodos.NodoTarjetaLD;
import Logica.ManageColumns;

/**
 *
 * @author xhunik
 */
public class TarjetasLD implements ManageColumns{
    public NodoTarjetaLD ini;
    public NodoTarjetaLD end;
    public int contador;
    public String nombre;
    
    @Override
    public void add(Tarjeta t) throws InvalidTitleCardException {
        insertarAlFrente(t);
    }

    @Override
    public Tarjeta delete() throws ListaVaciaException{
        return eliminarAlFinal();
    }
    
   
    
    public TarjetasLD(String nombre){
        this.nombre = nombre;
        ini = end = null;
        contador = 0;
    }
    
    public TarjetasLD(){
        this("Tarjetas Registrados");
    }
    
    //false si no existe, true si si existe
    public boolean checkExistsByTitle(String title){
        NodoTarjetaLD act = ini;
        while (act != null){
            if (act.dato.title.equals(title))
                return true;
            act = act.sig;
        }
        return false;
    }
    
    public void insertarAlFrente(Tarjeta dato) throws InvalidTitleCardException {
        if (checkExistsByTitle(dato.title))
            throw new InvalidTitleCardException();
        
        if (estaVacia())
            ini = end = new NodoTarjetaLD(dato);
        else
            ini = ini.ant = new NodoTarjetaLD(dato, null, ini);
        
        contador++;
    }
    
    public void insertarAlFinal(Tarjeta dato) throws InvalidTitleCardException {
        if (checkExistsByTitle(dato.title))
            throw new InvalidTitleCardException();
        
        if (estaVacia())
            ini = end = new NodoTarjetaLD(dato);
        else
            end = end.sig = new NodoTarjetaLD(dato, end, null);
        
        contador++;
    }
    
    public Tarjeta eliminarAlFrente() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Tarjeta datosAct = ini.dato;
        
        if (ini == end)
            ini = end = null;
        else{
            ini = ini.sig;
            ini.ant = null;
        }
        contador--;
        return datosAct;
    }
    
    public Tarjeta eliminarAlFinal() throws ListaVaciaException {
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Tarjeta datosAct = end.dato;
        
        if (ini == end)
            ini = end = null;
        else {
            end = end.ant;
            end.sig = null;
        }
        contador--;
        return datosAct;
    }
    
    public Tarjeta[] getArrayTarjeta() throws ListaVaciaException {
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Tarjeta[] retorno = new Tarjeta[contador];
        NodoTarjetaLD act = ini;
        int i = 0;
        while (act != null){
            retorno[i] = act.dato;
            act = act.sig;
            i++;
        }
        return retorno;
    }

    @Override
    public Tarjeta getTarjetaByTitle(String title) throws ListaVaciaException, TarjetaNotFoundException {
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        NodoTarjetaLD act = ini;
        while (act != null){
            if (act.dato.title.equals(title))
                return act.dato;
            act =act.sig;
        }
        throw new TarjetaNotFoundException();
    }

    
    
    @Override
    public Tarjeta[] getArrayDataTarjetas() {
        return getArrayTarjeta();
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
        NodoTarjetaLD act = ini;
        
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
