/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Exceptions.ListaVaciaException;
import Logica.Elements.Tarjeta;

/**
 *
 * @author xhunik
 */
public interface ManageColumns {
    //public int contador;
    public abstract void add(Tarjeta t);
    public abstract Tarjeta delete() throws ListaVaciaException;
    public abstract Tarjeta[] getArrayDataTarjetas();
}
