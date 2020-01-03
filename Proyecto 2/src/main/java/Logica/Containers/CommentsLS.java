/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;

import AuxTemplates.*;
import Exceptions.*;
import Logica.Elements.Comentario;
import Logica.EspecNodos.NodoCommentLS;
/**
 *
 * @author xhunik
 */
public class CommentsLS {
    public NodoCommentLS ini;
    public int contador;
    public String nombre;
    
    public CommentsLS(String nombre){
        this.contador = 0;
        this.nombre = nombre;
        ini = null;
    }
    public CommentsLS(){
        this("mi lista");
    }
    public void insertarAlFrente(Comentario dato){
        if (estaVacia())
            ini = new NodoCommentLS(dato);
        else
            ini = new NodoCommentLS(dato, ini);
        
        contador++;
    }
    
    public void insertarAlFinal(Comentario dato){
        if (estaVacia())
            ini = new NodoCommentLS(dato);
        else{
            NodoCommentLS act = ini;
            NodoCommentLS ant = null;
            do {
                ant = act;
                act = act.sig;
            }while (act != null);
            ant.sig = act = new NodoCommentLS(dato, null);
        }
        contador++;
    }
    
    public Comentario eliminarAlFrente() throws ListaVaciaException{
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        
        Comentario datosAct = ini.dato;
        
        ini = ini.sig;
        contador--;
        return datosAct;
    }
    
    public Comentario eliminarAlFinal() throws ListaVaciaException {
        Comentario dato;
        if (estaVacia())
            throw new ListaVaciaException(nombre);
        else {
            NodoCommentLS act = ini;
            NodoCommentLS ant = null;
            while (act.sig != null){
                ant = act;
                act = act.sig;
            }
            dato = act.dato;
            ant.sig = act = null;
            
        }
        contador--;
        return dato;
    }
    
    public boolean estaVacia(){
        return (ini == null);
    }

    public void imprimir(){
        if (estaVacia()){
            System.out.println("La lista: " + nombre + " esta vacia");
            return;
        }
        System.out.println("La lista: " + nombre);
        NodoCommentLS act = ini;
        
        while (act != null){
            try {
            System.out.println(act.dato + "->" + act.sig.dato);
            }
            catch (NullPointerException npe){
                System.out.println(act.dato + "-> null");
                //npe.printStackTrace();
            }
            finally{act = act.sig;}
        }
    }
    
}
