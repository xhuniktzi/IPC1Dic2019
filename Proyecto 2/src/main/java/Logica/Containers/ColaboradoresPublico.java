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
public class ColaboradoresPublico implements ManageColabs{

    @Override
    public void addColabs(Colaborador c) {
        throw new UnsupportedOperationException("Visibilidad publica, operacion invalida");
    }

    @Override
    public Colaborador deleteColabs() {
        throw new UnsupportedOperationException("Visibilidad publica, operacion invalida"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Colaborador[] getArrayColabs() {
        return App.gestor.colaboradoresRegistrados.getArrayColaborador();
    }
    
}
