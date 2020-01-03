/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Containers;

import AuxTemplates.*;
import AuxTemplates.ListaSimpleLineal;
import Exceptions.ListaVaciaException;
import Logica.Elements.Comentario;
import Logica.EspecNodos.NodoCommentLS;


/**
 *
 * @author xhunik
 */
public class ColaComentarios extends CommentsLS{

    public ColaComentarios(String nombre) {super(nombre);}
    
    public void enqueue(Comentario dato){super.insertarAlFinal(dato);}
    
    public Comentario dequeue()throws ListaVaciaException{return super.eliminarAlFrente();}

    @Override
    public void imprimir(){super.imprimir();}
    
    public Comentario[] getComments(){

        
        Comentario[] retorno = new Comentario[contador];
        int i = 0;
        NodoCommentLS act = ini;
        while (act != null){
            retorno[i] = act.dato;
            
            i++;
            act = act.sig;
        }
        return retorno;
    }
}
