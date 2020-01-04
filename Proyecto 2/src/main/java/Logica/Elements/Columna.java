/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Elements;

import Exceptions.ListaVaciaException;
import Exceptions.TitleCardVacioException;
import Logica.Containers.TarjetasCola;
import Logica.Containers.TarjetasLD;
import Logica.Containers.TarjetasPila;
import Logica.ManageColumns;

/**
 *
 * @author xhunik
 */
public class Columna {
    //implementar excepciones si se intenta una operacion invalida en la estrucutura
    //public int id; // id de la columna
    public String nombre;
    public ManageColumns tarjetas;
    public Mode modo;

    public Columna(String nombre, Mode mode) {
        //this.id = id;
        this.nombre = nombre;
        this.modo = mode;
        if (modo == Mode.PILA)
            tarjetas = new TarjetasPila();
        if (modo == Mode.COLA)
            tarjetas = new TarjetasCola();
        if (modo == Mode.DOBLE)
            tarjetas = new TarjetasLD();
    }
    
    public Columna(String nombre){
        this(nombre,Mode.DOBLE);
    }
    
    public void addTarjeta(Tarjeta t) throws TitleCardVacioException {
        if (t.title.equals(""))
            throw new TitleCardVacioException();
        
        tarjetas.add(t);
    }
    
    public Tarjeta deleteTarjeta() throws ListaVaciaException{
        return tarjetas.delete();
    }
    
    public static enum Mode{
        DOBLE,PILA,COLA;

        @Override
        public String toString() {
            switch (this){
                case DOBLE: return "doble";
                case PILA: return "pila";
                case COLA: return "cola";
                default: return null;
            }
        }
        
    }
}
