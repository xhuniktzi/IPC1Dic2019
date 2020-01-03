/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Exceptions.InvalidNickException;
import Exceptions.InvalidTitleTabException;
import Exceptions.ListaVaciaException;
import Exceptions.TabNotFoundException;
import Logica.Containers.ColaboradoresLD;
import Logica.Containers.ColaboradoresLS;
import Logica.Containers.TablerosCS;
import Logica.Elements.Colaborador;
import Logica.Elements.Tablero;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
}
