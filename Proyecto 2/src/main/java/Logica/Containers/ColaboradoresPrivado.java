/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;

import Logica.Elements.Colaborador;
import Logica.ManageColabs;
import Vista.App;

/**
 *
 * @author xhunik
 */
public class ColaboradoresPrivado extends ColaboradoresLS implements ManageColabs{

    @Override
    public void addColabs(Colaborador c) throws UnsupportedOperationException {
        super.insertarColaborador(c);
    }

    @Override
    public Colaborador deleteColabs() throws UnsupportedOperationException {
        return super.eliminarAlFrente();
    }

    @Override
    public Colaborador[] getArrayColabs() {
        return super.getColaboradoresArray();
    }
    
}
