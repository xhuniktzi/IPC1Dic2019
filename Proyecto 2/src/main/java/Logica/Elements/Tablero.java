/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Elements;

import Exceptions.InvalidNameColException;
import Logica.Containers.ColaboradoresPrivado;
import Logica.Containers.ColaboradoresPublico;
import Logica.Containers.ColumnasCD;
import Logica.ManageColabs;

/**
 *
 * @author xhunik
 */
public class Tablero {
    public String nombre;
    //public Visibility visibilidad;
    public String hexColor;  //color en formato hexadecimal
    public ColumnasCD columnas;
    public ManageColabs colabs;
    //public int contadorCols;
    //public ColaboradoresLS listaColabs; //ToDO: Reimplemntar con interfaces
    

    public Tablero(String nombre, String hexColor) {
        this(nombre, hexColor, Visibility.PUBLICO);
    }
    
    public Tablero(String nombre, String hexColor, Visibility visible){
        this.nombre = nombre;
        this.columnas = new ColumnasCD("columnas",this);
        this.hexColor = hexColor;
        addCols(new Columna("Lista de tareas"));
        if (visible == Visibility.PUBLICO)
            colabs = new ColaboradoresPublico();
        if (visible ==Visibility.PRIVADO)
            colabs = new ColaboradoresPrivado();
        
    }
    
    public void addCols(Columna c) throws InvalidNameColException{
        columnas.insertar(c);
        //contadorCols++;
    }
    public Columna deleteCols(Columna c){
        return columnas.eliminarColumnaByName(c.nombre);
    }
    public void moveBack(Columna c){
        columnas.moveToBackByName(c.nombre);
    }
    
    public void moveForward(Columna c){
        columnas.moveToForwardByName(c.nombre);
    }

    public void addColab(Colaborador c) throws UnsupportedOperationException{
        colabs.addColabs(c);
    }
    
    public Colaborador delColab() throws UnsupportedOperationException{
        return colabs.deleteColabs();
    }
    
    public Colaborador[] getDataColabs(){
        return colabs.getArrayColabs();
    }
    
    public static enum Visibility {
        PUBLICO,PRIVADO;

        @Override
        public String toString() {
            switch (this){
                case PUBLICO: return "publico";
                case PRIVADO: return "privado";
                default: return null;
            }
        }
        
    }

}
