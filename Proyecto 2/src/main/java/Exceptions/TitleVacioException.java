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
public class TitleVacioException extends RuntimeException{

    public TitleVacioException() {
        super("Titulo de tablero vacio");
    }
    
}
