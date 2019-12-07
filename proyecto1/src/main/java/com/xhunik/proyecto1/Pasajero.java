/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.proyecto1;

import java.util.Random;

/**
 *
 * @author xhunik
 */



public class Pasajero {
    private Random rand = new Random();
    private static int contadorPasajeros = 0;//para generar id unicos
    
    private int id;
    private int cantidadMaletas;
    private int cantidadDocumentos;
    private int turnosRegistro;
    
    private Maleta listaMaletas[];
    
    public Pasajero (){
        this.randomDocumentos();
        this.randomMaletas();
        this.randomRegistro();
        
        this.listaMaletas = new Maleta[this.cantidadMaletas];
        initMaletas();
    }
    public Maleta[] getMaletas(){
        return this.listaMaletas;
    }
    
    private void initMaletas(){
        int i;
        for (i = 0; i < this.listaMaletas.length; i++){
            this.listaMaletas[i] = new Maleta(this.id,i+1);
        }
    }
    public int getId(){
        return this.id;
    }
    
    public int getTurnosRegistro(){
        return this.turnosRegistro;
    }
    
    public int getCantidadMaletas(){
        return this.cantidadMaletas;
    }
    
    public int getCantidadDocumentos(){
        return this.cantidadMaletas;
    }
    
    private void setId(){
        contadorPasajeros++;
        this.id = contadorPasajeros;
    }
    
    private void randomRegistro(){
        int min = 1;
        int max = 3;
        //ejecuta una funcion matematica para obtener aleatoriamente
        //el numero de turnos
        this.turnosRegistro = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
        private void randomMaletas(){
        int min = 1;
        int max = 4;
        //ejecuta una funcion matematica para obtener aleatoriamente
        //el numero de turnos
        this.cantidadMaletas = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
            private void randomDocumentos(){
        int min = 1;
        int max = 10;
        //ejecuta una funcion matematica para obtener aleatoriamente
        //el numero de turnos
        this.cantidadDocumentos = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
}
