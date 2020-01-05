/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Exceptions.InvalidNameColException;
import Exceptions.InvalidNickException;
import Exceptions.InvalidTitleTabException;
import Exceptions.ListaVaciaException;
import Exceptions.TabNotFoundException;
import Logica.Containers.ColaboradoresLD;
import Logica.Containers.ColaboradoresLS;
import Logica.Containers.TablerosCS;
import Logica.Elements.Colaborador;
import Logica.Elements.Columna;
import Logica.Elements.Tablero;
import Logica.Elements.Tarjeta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author xhunik
 */
public class Gestor {
    public ColaboradoresLD colaboradoresRegistrados;
    public TablerosCS tablerosCreados;

    public Gestor() {
        colaboradoresRegistrados = new ColaboradoresLD("colaboradores registrados");
        tablerosCreados = new TablerosCS("Tableros Creados");
    }
    public void addColaborador(Colaborador c) throws InvalidNickException{
        colaboradoresRegistrados.insertarColaborador(c);
    }
    public String[][] getArrayDataColaboradores(){
        Colaborador[] colaboradores = colaboradoresRegistrados.getArrayColaborador();
        String[][] retorno = new String[4][colaboradores.length];
        for (int i = 0; i<colaboradores.length; i++){
            retorno[0][i] = colaboradores[i].nombre;
            retorno[1][i] = colaboradores[i].nickname;
            retorno[2][i] = colaboradores[i].rol;
            retorno[3][i] = String.valueOf(colaboradores[i].telfono);
        }
        return retorno;
    }
    public ColaboradoresLS getColaboradoresRegistrados(){
        ColaboradoresLS colabs = new ColaboradoresLS("Register Colaboradores");
        Colaborador[] colaboradores = colaboradoresRegistrados.getArrayColaborador();
        for (int i = 0; i < colaboradores.length;i++){
            colabs.insertarColaborador(colaboradores[i]);
        }
        return colabs;
    }
    public void addTablero(Tablero t) throws InvalidTitleTabException{
        tablerosCreados.insertar(t);
    }
    
    public String[][] getArrayDataTableros() throws ListaVaciaException{
        Tablero[] tabs = tablerosCreados.getArrayTableros();
        String[][] retorno = new String[2][tabs.length];
        for (int i = 0; i < tabs.length;i++){
            retorno[0][i] = tabs[i].nombre;
           
            retorno[1][i] = tabs[i].hexColor;
        }
        return retorno;
    }
    public Tablero getTablerosByTitle(String title) throws TabNotFoundException,ListaVaciaException{
        return tablerosCreados.getTableroByTitle(title);
    }
    public Tablero[] getTableros(){
        return tablerosCreados.getArrayTableros();
    }
    public Tablero deleteTablero(Tablero t){
        return tablerosCreados.deleteTableroByTitle(t.nombre);
    }
    
    public void loadColaboradoresFromCSV(File file) throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        //nombre,nick,rol, telefono
        cadena = b.readLine();
        while ((cadena = b.readLine())!=null){
            String[] elements = cadena.split(",");
            addColaborador(new Colaborador(elements[0],elements[1],elements[2],Integer.parseInt(elements[3])));
        }
        b.close();
   }
    
    public void loadTablerosFromCSV(File file) throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        //nombre, color
        while ((cadena = b.readLine())!=null){
            String[] elements = cadena.split(",");
            try{
            addTablero(new Tablero(elements[0], elements[1]));
            } catch (InvalidTitleTabException itte){
                continue;
            }
        }
        b.close();
        
    }
    public void loadColumnasFromCSV(File file) throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        //Tablero, TituloLista, Tipo de columna, Titulo tarjeta, desc, colab, prioridad, nick, comment
        while ((cadena = b.readLine())!= null){
            String[] elements = cadena.split(",");
            Tablero tab = getTablerosByTitle(elements[0]);
            try{
                if (elements[2].contains("Pila"))
                    tab.addCols(new Columna(elements[1], Columna.Mode.PILA));
                if (elements[2].contains("Cola"))
                    tab.addCols(new Columna(elements[1], Columna.Mode.COLA));
                if (elements[2].contains("Lista"))
                    tab.addCols(new Columna(elements[1], Columna.Mode.DOBLE));

                Columna col = tab.columnas.getColumnaByName(elements[1]);
                try{
                //verificar si no esta vacia
                    if (elements[6].contains("alta")){
                        col.addTarjeta(new Tarjeta(elements[3],elements[4],Tarjeta.Priority.ALTA,elements[5]));
                        //agregar comentario
                    }
                    if (elements[6].contains("media")){
                        col.addTarjeta(new Tarjeta(elements[3],elements[4],Tarjeta.Priority.MEDIA,elements[5]));
                        //agregar comentario
                    }
                    if (elements[6].contains("baja")){
                        col.addTarjeta(new Tarjeta(elements[3],elements[4],Tarjeta.Priority.BAJA,elements[5]));
                        //agregar comentario
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe){
                    //System.err.println("Crea columna -> no añade tarjeta" + col.nombre);
                    //aioobe.printStackTrace();
                    
                }
            } catch (InvalidNameColException ince){
                
                Columna col = tab.columnas.getColumnaByName(elements[1]);
                try{
                //verificar si no esta vacia
                    if (elements[6].contains("alta")){
                        col.addTarjeta(new Tarjeta(elements[3],elements[4],Tarjeta.Priority.ALTA,elements[5]));
                        //agregar comentario
                    }
                    if (elements[6].contains("media")){
                        col.addTarjeta(new Tarjeta(elements[3],elements[4],Tarjeta.Priority.MEDIA,elements[5]));
                        //agregar comentario
                    }
                    if (elements[6].contains("baja")){
                        col.addTarjeta(new Tarjeta(elements[3],elements[4],Tarjeta.Priority.BAJA,elements[5]));
                        //agregar comentario
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe){
                    //System.err.println("No Crea columna -> no añade tarjeta");
                }
                
            }
                
        }
        
    }
}
