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
    
    //pasar boolean true signfica que debe crear un pasajero
    //pasar boolean false significa que debe dejarlo con argumentos genericos
    public Pasajero (boolean flag){
        if (flag){
            this.randomDocumentos();
            this.randomMaletas();
            this.randomRegistro();
            this.setId();

            this.listaMaletas = new Maleta[this.cantidadMaletas];
            initMaletas();
        }
        else {
            this.setId(0);
            this.setDocumentos(0);
            this.setRegistro(0);
        }
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
    
    public void setId(int id){
        this.id = id;
    }
    
    private void randomRegistro(){
        int min = 1;
        int max = 3;
        //ejecuta una funcion matematica para obtener aleatoriamente
        //el numero de turnos
        this.turnosRegistro = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
    
    public void setRegistro(int registro){
        this.turnosRegistro = registro;
    }
    
    private void randomMaletas(){
    int min = 1;
    int max = 4;
    //ejecuta una funcion matematica para obtener aleatoriamente
    //el numero de turnos
    this.cantidadMaletas = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
    
    public void setMaletas(int maletas){
        this.cantidadMaletas = maletas;
    }
    
    private void randomDocumentos(){
    int min = 1;
    int max = 10;
    //ejecuta una funcion matematica para obtener aleatoriamente
    //el numero de turnos
    this.cantidadDocumentos = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
    public void setDocumentos(int documentos){
        this.cantidadDocumentos = documentos;
    }
}
