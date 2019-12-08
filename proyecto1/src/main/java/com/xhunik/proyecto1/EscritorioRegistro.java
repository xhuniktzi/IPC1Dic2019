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
public class EscritorioRegistro{
    private static char contadorId = 'a';
    private char id;
    private int tamaño;
    private int contenido = 0;
    private Pasajero[] colaPasajeros;
    
    public EscritorioRegistro(int tColas){
        this.colaPasajeros = new Pasajero[tColas];
        this.tamaño = tColas;
        this.initColaPasejeros();
        this.id = contadorId;
        contadorId++;
    }
//addPasajero devuelve falso si no puede ingresar el nuevo elemento            
    public boolean addPasajero(Pasajero p){
        if (this.tamaño > this.contenido){
            this.colaPasajeros[this.contenido].setId(p.getId());
            this.colaPasajeros[this.contenido].setDocumentos(p.getCantidadDocumentos());
            this.colaPasajeros[this.contenido].setMaletas(p.getCantidadMaletas());
            this.colaPasajeros[this.contenido].setRegistro(p.getTurnosRegistro());
            return true;
        }
        else {
            return false;
        }
    }
    
    public Pasajero getPasajeroActual(){
        Pasajero p = this.colaPasajeros[0];
        return p;
    }
    private void initColaPasejeros(){
        int i;
        for (i = 0; i < this.colaPasajeros.length; i++){
            this.colaPasajeros[i] = new Pasajero(false);
        }
    }
    
    
}