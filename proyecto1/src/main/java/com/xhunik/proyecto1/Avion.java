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
public class Avion {
    private enum TipoAvion{SMALL,MEDIUM,BIG};
    private Random rand = new Random();
    private static int contadorAviones = 0;//para generar id unicos
    
    private int id;
    private TipoAvion tipo;
    private int pasajeros;
    private int turnosDesabordaje;
    private int turnosMantenimiento;
    
    private Pasajero[] listaPasajeros;
    public Avion(){
        //generar aleatoriamente el tipo de avion
        this.setId();
        this.randomTipo();
        this.randomPasajeros();
        this.randomMantenimiento();
        
        if (this.tipo == TipoAvion.SMALL)
            this.setTurnosDesabordaje(1);
        if (this.tipo == TipoAvion.MEDIUM)
            this.setTurnosDesabordaje(2);
        if (this.tipo == TipoAvion.BIG)
            this.setTurnosDesabordaje(3);
        
        this.listaPasajeros = new Pasajero[this.pasajeros];
        this.initPasajeros();
    }
    
    private void initPasajeros(){
        int i;
        for (i = 0; i < this.listaPasajeros.length; i++){
            this.listaPasajeros[i]  = new Pasajero();
        }
    }
    public int getCantPasajeros(){
        return this.pasajeros;
    }
    public void setTurnosDesabordaje(int t){
        this.turnosDesabordaje = t;
    }
    
    public int getTurnosDesabordaje(){
        return this.turnosDesabordaje;
    }
    
    public int getTurnosMantenimiento(){
        return this.turnosMantenimiento;
    }
    
    public int getId(){
        return this.id;
    }
    
    public Pasajero[] getPasajeros(){
        return this.listaPasajeros;
    }
    
    private void setId(){
        contadorAviones++;
        this.id = contadorAviones;
    }
    
    private void randomTipo(){
        //genera un valor entre 0 y 1
        double rndTemp;
        rndTemp = rand.nextDouble();
        
        //compara los valores en los rangos [0,25],(25,55),[55,100] %
        //tamaños de rangos: 25, 30, 45
        //el tamaño se corresponde a la probabilidad de obtener un numero en
        //ese rango
        if (rndTemp >= 0 && rndTemp <= 0.25)
            this.tipo = TipoAvion.SMALL;
        if (rndTemp > 0.25 && rndTemp < 0.55)
            this.tipo = TipoAvion.MEDIUM;
        if (rndTemp >= 0.55 && rndTemp <= 1)
            this.tipo = TipoAvion.BIG;
    }
    
    private void randomPasajeros(){
        //fijar los rangos segun el tipo de avion
        int min = 0;
        int max = 0;
        if (this.tipo == TipoAvion.SMALL){
            min = 5;
            max = 10;
        }
        if (this.tipo == TipoAvion.MEDIUM){
            min = 15;
            max = 25;
        }
        if (this.tipo == TipoAvion.BIG){
            min = 30;
            max = 40;
        }
        //ejecuta una funcion matematica para obtener aleatoriamente
        //la cantidad de pasajeros
        this.pasajeros = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
    public void randomMantenimiento(){
        //fijar los rangos segun el tipo de avion
        int min = 0;
        int max = 0;
        if (this.tipo == TipoAvion.SMALL){
            min = 1;
            max = 3;
        }
        if (this.tipo == TipoAvion.MEDIUM){
            min = 2;
            max = 4;
        }
        if (this.tipo == TipoAvion.BIG){
            min = 3;
            max = 6;
        }
        //ejecuta una funcion matematica para obtener aleatoriamente
        //el numero de turnos
        this.turnosMantenimiento = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
}
