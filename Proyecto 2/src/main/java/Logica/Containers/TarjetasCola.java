/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;

import Exceptions.ListaVaciaException;
import Logica.Elements.Tarjeta;
import Logica.EspecNodos.NodoTarjetaLS;
import Logica.ManageColumns;

/**
 *
 * @author xhunik
 */
public class TarjetasCola extends TarjetasLS implements ManageColumns{

    public TarjetasCola(String nombre) {super(nombre);}
    
    public TarjetasCola(){this("mi Lista");}
    
    public void enqueue(Tarjeta dato){super.insertarAlFinal(dato);}
    
    public Tarjeta dequeue()throws ListaVaciaException{return super.eliminarAlFrente();}

    @Override
    public void imprimir(){super.imprimir();}
    
    @Override
    public void add(Tarjeta t) {
        enqueue(t);
    }

    @Override
    public Tarjeta[] getArrayDataTarjetas() throws ListaVaciaException{
        return super.getArrayTarjeta();
    }
    
    

    @Override
    public Tarjeta delete() throws ListaVaciaException{
        return dequeue();
    }
    
}
