/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.proyecto1;

/**
 *
 * @author xhunik
 */
public class Maleta {
    private int id;
    private int idPasajero;
    public Maleta(int idP, int idM){
        this.idPasajero = idP;
        this.id = idM;
        
    }
    public String getId(){
        String str = "";
        str = this.idPasajero + "-" + this.id;
        return str;
    }
}
