/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Elements.Colaborador;

/**
 *
 * @author xhunik
 */
public interface ManageColabs {
    public abstract void addColabs(Colaborador c) throws UnsupportedOperationException;
    public abstract Colaborador deleteColabs() throws UnsupportedOperationException;
    public abstract Colaborador[] getArrayColabs();
}
