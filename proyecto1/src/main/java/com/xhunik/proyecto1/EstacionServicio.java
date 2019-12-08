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

public class EstacionServicio{
    private static char contadorId = 'a';
    private char id;
    private int tamaño;
    private int contenido;
    private Avion[] colaAviones;
    
    public EstacionServicio(int tColas){
        this.colaAviones = new Avion[tColas];
        this.tamaño = tColas;
        this.initColaAviones();
        this.id = contadorId;
        contadorId++;
    }
    
//addAvion devuelve falso si no puede ingresar el nuevo elemento            
    public boolean addAvion(Avion a){
        if (this.tamaño > this.contenido){
            this.colaAviones[this.contenido].setId(a.getId());
            this.colaAviones[this.contenido].setTurnosMantenimiento(a.getTurnosMantenimiento());
            this.contenido++;
            return true;
        }
        else {
            return false;
        }
    }
    
    public Avion getAvionActual(){
        Avion a = this.colaAviones[0];
        return a;
    }
    private void initColaAviones(){
        int i;
        for (i = 0; i < this.colaAviones.length; i++){
            this.colaAviones[i] = new Avion(false);
        }
    }
}

