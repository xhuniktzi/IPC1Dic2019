/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.EspecNodos;

import AuxTemplates.*;
import Logica.Elements.Comentario;

/**
 *
 * @author xhunik
 */
public class NodoCommentLS {
    public Comentario dato;
    public NodoCommentLS sig;
    
    public NodoCommentLS(Comentario dato,NodoCommentLS sig){
        this.dato = dato;
        this.sig = sig;
    }
    public NodoCommentLS(Comentario dato){
        this(dato,null);
    }
}
