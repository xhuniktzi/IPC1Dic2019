/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Elements;

import Exceptions.InvalidNameColException;
import Logica.Containers.ColumnasCD;

/**
 *
 * @author xhunik
 */
public class Tablero {
    public String nombre;
    //public Visibility visibilidad;
    public String hexColor;  //color en formato hexadecimal
    public ColumnasCD columnas;
    //public int contadorCols;
    //public ColaboradoresLS listaColabs; //ToDO: Reimplemntar con interfaces
    

    public Tablero(String nombre, String hexColor) {
        //contadorCols = 0;
        this.nombre = nombre;
        this.columnas = new ColumnasCD("columnas",this);
        //this.visibilidad = visibilidad;
        this.hexColor = hexColor;
        //if (visibilidad == Visibility.PUBLICO)
          //  listaColabs = App.gestor.getColaboradoresRegistrados();
        
        addCols(new Columna("Lista de tareas"));
    }
    
    public void addCols(Columna c) throws InvalidNameColException{
        columnas.insertar(c);
        //contadorCols++;
    }
    public Columna deleteCols(Columna c){
        return columnas.eliminarColumnaByName(c.nombre);
    }

    /*
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
*/
}
