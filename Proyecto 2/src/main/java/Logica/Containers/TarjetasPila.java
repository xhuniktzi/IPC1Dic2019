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
import Logica.ManageColumns;

/**
 *
 * @author xhunik
 */
public class TarjetasPila extends TarjetasLS implements ManageColumns {

    public TarjetasPila(String nombre) {super(nombre);}
    
    public TarjetasPila(){this("mi Lista");}


    public Tarjeta pop() throws ListaVaciaException{
        return super.eliminarAlFrente();
    }
    
    public void push(Tarjeta dato) throws InvalidTitleCardException{super.insertarAlFrente(dato);}
    
    @Override
    public void imprimir(){super.imprimir();}
    
    @Override
    public void add(Tarjeta t) throws InvalidTitleCardException {
        push(t);
    }

    @Override
    public Tarjeta[] getArrayDataTarjetas() throws ListaVaciaException {
        return super.getArrayTarjeta();
    }

    @Override
    public Tarjeta getTarjetaByTitle(String title) throws ListaVaciaException, TarjetaNotFoundException {
        return super.getTarjetaByTitle(title);
    }

    
    
    @Override
    public Tarjeta delete() throws ListaVaciaException{
        return pop();
    }
    
}
