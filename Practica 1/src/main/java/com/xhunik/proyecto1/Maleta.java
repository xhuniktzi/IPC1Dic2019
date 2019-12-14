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
    private int idMaleta;
    private int idPasajero;
    private int UID;
    private boolean flag;
    
    public Maleta(int m, int p){
        idMaleta = m;
        idPasajero = p;
        UID = (p*10)+m;
        flag = true;
    }
    public Maleta(boolean bool){
        idMaleta = 0;
        idPasajero = 0;
        UID = 0;
        flag = bool;
    }
    public Maleta(Maleta m){
        idMaleta = m.idMaleta;
        idPasajero = m.idPasajero;
        UID = m.UID;
        flag = m.flag;
    }

    public int getUID() {
        return UID;
    }
    public boolean isFlag(){
        return flag;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public int getIdMaleta() {
        return idMaleta;
    }
    
    
}
