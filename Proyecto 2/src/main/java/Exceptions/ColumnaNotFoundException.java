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
public class ColumnaNotFoundException extends RuntimeException{

    public ColumnaNotFoundException() {
        super("columna no encontrada");
    }
    
}
