/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;

import Exceptions.ColumnaNotFoundException;
import Exceptions.InvalidNameColException;
import Exceptions.ListaVaciaException;
import Exceptions.NameColVacioException;
import Logica.Elements.Columna;
import Logica.Elements.Tablero;
import Logica.EspecNodos.NodoColumnaCD;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhunik
 */
public class ColumnasCD {
    public NodoColumnaCD ini;
    public NodoColumnaCD end;
    public int contador;
    public String nombre;
    public Tablero superior;
    
    public ColumnasCD(String nombre,Tablero superior){
        ini = null;
        end = null;
        this.superior = superior;
        this.nombre = nombre;
    }
    public ColumnasCD(){
        this("mi Lista",null);
    }
    
    public void insertar(Columna dato) throws InvalidNameColException, NameColVacioException{
        if (dato.nombre.equals(""))
            throw new NameColVacioException();
        
        if (!estaVacia()){
            if (checkExistsNombre(dato.nombre))
                throw new InvalidNameColException();
        }
        
        NodoColumnaCD nodo = new NodoColumnaCD(dato);
        if (estaVacia()){
            ini = end = nodo;
            nodo.sig = nodo;
            nodo.ant = nodo;
        }
        else {
            end.sig = nodo;
            nodo.sig = ini;
            nodo.ant = end;
            end = nodo;
            ini.ant = end;
        }
        contador++;
    }
    
    public Columna[] getArrayColumnas() throws ListaVaciaException {
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Columna[] retorno = new Columna[contador];
        int i = 0;
        NodoColumnaCD act = ini;
        do {
            retorno[i] = act.dato;
            i++;
            act = act.sig;
        }  while (act!= ini);
        return retorno;
    }
    
    public boolean checkExistsNombre(String nombre){
        NodoColumnaCD act = ini;
        do {
            if (act.dato.nombre.equals(nombre))
                return true;
            
            act = act.sig;
        }  while (act!= ini);
        return false;
        
    }
    
    public Columna eliminar() throws ListaVaciaException{
        //NodoColumnaCD act = ini;
        //NodoColumnaCD ant = end;
        
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Columna dato = ini.dato;
        ini = ini.sig;
        end.sig = ini;
        ini.ant = end;
        contador--;
        return dato;
        
    }
   
    
    //get columna by title
    public Columna getColumnaByName(String name) throws ListaVaciaException,ColumnaNotFoundException {
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        NodoColumnaCD act = ini;
        do {
            if (act.dato.nombre.equals(name))
                return act.dato;
            act = act.sig;
        }  while (act!= ini);
        throw new ColumnaNotFoundException();
    }
    
    
    public boolean estaVacia(){
        return (ini == null && end ==null);
    }
    
    public void drawGraphviz(String ruta) throws IOException{
        //imprimir();
        String nameFile = superior.nombre.replace(" ", "");
        
        String path = ruta + "/dot/columna_" + nameFile + ".dot";
        String pathImg = ruta + "/img/columna_" + nameFile + ".jpg";
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
            txt.println("ini->"+ini.hashCode());
            NodoColumnaCD act = ini;
            do {
                txt.println(act.hashCode() + "->" + act.sig.hashCode());
                txt.println(act.hashCode() + "->" + act.ant.hashCode());
                txt.println(act.hashCode() + " [label=\"" + act.dato.nombre + "\"];");
                txt.println(act.sig.hashCode() + " [label=\"" + act.sig.dato.nombre + "\"];");
                txt.println(act.ant.hashCode() + " [label=\"" + act.ant.dato.nombre + "\"];");
                
                act = act.sig;
            } while (act!= ini);
            
        }
        
        txt.println("}");
        
        txt.close();
        txt2.close();
        
        String command = "dot -Tjpg " + path + " -o " + pathImg;
        
        Runtime run = Runtime.getRuntime();
        run.exec(command);
        
    }
    
    public void imprimir(){
        if (estaVacia()){
            System.out.println("La lista. "+ nombre+ " esta vacia");
            return;
        }
        
        NodoColumnaCD act = ini;
        do {
            System.out.println(act.ant.dato.nombre+"<-"+act.dato.nombre+"->"+act.sig.dato.nombre);
            act = act.sig;
        }  while (act!= ini);
    }
}
