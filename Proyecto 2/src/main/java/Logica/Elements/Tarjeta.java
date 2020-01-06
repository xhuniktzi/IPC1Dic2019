/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Elements;

import Exceptions.ListaVaciaException;
import Logica.Containers.ColaComentarios;
import Logica.Containers.ColaboradoresLS;

/**
 *
 * @author xhunik
 */
public class Tarjeta {
    
    public String title;
    public String desc;
    public Priority prioridad;
    //public ColaboradoresLS colaboradores;
    public String nickColaborador;
    public ColaComentarios comentarios;

    public Tarjeta(String title, String desc, Priority prioridad,String nickColaborador) {
        
        this.title = title;
        this.desc = desc;
        this.prioridad = prioridad;
        this.nickColaborador = nickColaborador;
        //this.colaboradores = new ColaboradoresLS("colaboradores");
        this.comentarios = new ColaComentarios("comentarios");
        
    }
    public Tarjeta (String title, String desc){
        this(title,desc,Priority.MEDIA,"");
    }
    
    public void addComentario(Comentario dato){
        comentarios.enqueue(dato);
    }
    
    public Comentario deleteComentario(){
        return comentarios.dequeue();
    }
    
    public String[][] getArrayDataComments() {
        
        Comentario[] comments = comentarios.getComments();
        String[][] retorno = new String[2][comments.length];
        for (int i = 0; i < comments.length; i++){
            retorno[0][i] = comments[i].owner;
            retorno[1][i] = comments[i].comment;
        }
        return retorno;
      
    }
    
    public static enum Priority{
        ALTA,MEDIA,BAJA;

        @Override
        public String toString() {
            switch (this){
                case ALTA: return "alta";
                case BAJA: return "baja";
                case MEDIA: return "media";
                default: return null;
            }
        }
        
    }
}
