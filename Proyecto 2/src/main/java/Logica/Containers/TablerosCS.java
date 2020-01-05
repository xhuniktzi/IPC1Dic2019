/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;

import Exceptions.InvalidTitleTabException;
import Exceptions.ListaVaciaException;
import Exceptions.TabNotFoundException;
import Exceptions.TitleVacioException;
import Logica.Elements.Tablero;
import Logica.EspecNodos.NodoTableroCS;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author xhunik
 */
public class TablerosCS {
    public NodoTableroCS end;
    public String nombre;
    public int contador;
    public TablerosCS(String nombre){
        this.nombre = nombre;
        end = null;
        contador = 0;
    }
    public TablerosCS(){this("mi Lista");}
    
    public boolean estaVacia(){
        return (end == null);
    }
    public void insertar(Tablero dato) throws InvalidTitleTabException, TitleVacioException{
        if (dato.nombre.equals(""))
            throw new TitleVacioException();
        
        NodoTableroCS nodo = new NodoTableroCS(dato);
        if (checkExistsTableroTitle(dato.nombre))
            throw new InvalidTitleTabException();
        else{    
            if (end != null){
                nodo.sig = end.sig;
                end.sig = nodo;
                
            }
            else{
                end = nodo;
                
            }
            contador++;
        }
      
    }
    
    public Tablero eliminar() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        NodoTableroCS act = end;
        NodoTableroCS aux = act.sig;
        Tablero dato = aux.dato;
        if (end == end.sig){
            end = null;
            
        }
        else{
            if  (aux == end)
                end = act;
            act.sig = aux.sig;
            
        }
        //add drawgrpahviz
        contador--;
        return dato;
    }
    public boolean checkExistsTableroTitle(String title){
        if (end == null)
            return false;
        NodoTableroCS act = end.sig;
        do{
            if (act.dato.nombre.equals(title))
                return true;
            act = act.sig;
        } while(act != end.sig);
        return false;
    }
    
    public Tablero getTableroByTitle(String title) throws TabNotFoundException,ListaVaciaException{
        if (end == null)
            throw new ListaVaciaException(nombre);
            
        NodoTableroCS act = end.sig;
        do{
            if (act.dato.nombre.equals(title))
                return act.dato;
            act = act.sig;
        } while(act != end.sig);
        throw new TabNotFoundException();
    }
    
    public Tablero[] getArrayTableros()throws ListaVaciaException{
        
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        NodoTableroCS act = end.sig;
        Tablero[] tabs = new Tablero[contador];
        int i = 0;
        do {
            tabs[i] = act.dato;
            
            act = act.sig;
            i++;
        } while(act != end.sig);
        return tabs;
    }
    
    public Tablero deleteTableroByTitle(String title) throws ListaVaciaException, TabNotFoundException{
        if (end == null)
            throw new ListaVaciaException(nombre);
            
        NodoTableroCS act = end.sig;
        NodoTableroCS ant = end;
        do{
            if (act.dato.nombre.equals(title)){
                if (act == ant){
                    Tablero data = act.dato;
                    eliminar();
                    return data;
                    
                }
                    
                Tablero data = act.dato;
                ant.sig = act.sig; // <- delete Tablero
                contador--;
                return data;
            }
            ant = act;
            act = act.sig;
        } while(act != end.sig);
        
        throw new TabNotFoundException();
    }
    
    
    public void drawGraphviz(String ruta) throws IOException{
        String path = ruta + "/dot/tableros.dot";
        String pathImg = ruta + "/img/tableros.jpg";
        File drawFile = new File(path);
        if (drawFile.exists()){
            drawFile.delete();
            drawFile.createNewFile();
        }
        else {
            drawFile.createNewFile();
        }
        
        FileWriter txt2 = new FileWriter(drawFile,true);
        PrintWriter txt = new PrintWriter(txt2);
        
        txt.println("digraph A{");
        if (estaVacia())
            txt.println("ini->null");
        else {
            txt.println("ini->" + end.hashCode());
            NodoTableroCS act = end.sig;
            do{
                txt.println(act.hashCode() + "->" + act.sig.hashCode());
                act = act.sig;
            }while (act != end.sig);
            
        }
        
        txt.println("}");
        
        txt.close();
        txt2.close();
        
        String command = "dot -Tjpg " + path + " -o " + pathImg;
        
        Runtime run = Runtime.getRuntime();
        run.exec(command);
    }
    
    
    public void imprimir(){
        
        if (estaVacia())
        {
            System.out.println("La lista: " + nombre + " esta vacia");
            return;
        }
        NodoTableroCS act = end.sig;
        do{
            System.out.println(act.dato + "->" + act.sig.dato);
            act = act.sig;
        }while (act != end.sig);
    }
}
