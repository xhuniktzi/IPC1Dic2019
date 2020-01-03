/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author xhunik
 */
public class ListaVaciaException extends RuntimeException{
    public ListaVaciaException(String nombre){
        super(nombre + " esta vacia");
    }
    public ListaVaciaException(){
        this("mi lista");
    }
}
