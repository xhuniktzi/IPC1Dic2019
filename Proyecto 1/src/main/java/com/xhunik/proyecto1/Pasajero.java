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
    static int idContador = 0;
    int id;
    int turnosRegistro;
    int documentos;
    int maletas;
    boolean flag;

    Random rand;
    public Pasajero() {
        rand = new Random();
        idContador++;
        id = idContador;
        randomTurnos();
        randomDocumentos();
        randomMaletas();
        flag = true;
    }
    public Pasajero(boolean bool){
        id = 0;
        turnosRegistro = 0;
        documentos = 0;
        maletas = 0;
        flag = bool;
    }
    
    public Pasajero(Pasajero p){
        //Pasajero pasajero = new Pasajero();
        id = p.id;
        turnosRegistro = p.turnosRegistro;
        documentos = p.documentos;
        maletas = p.maletas;
        flag = p.flag;
    }
    /*
    public Pasajero copiaPasajero(Pasajero p){
        Pasajero pasajero = new Pasajero();
        pasajero.id = p.id;
        pasajero.turnosRegistro = p.turnosRegistro;
        pasajero.documentos = p.documentos;
        pasajero.maletas = p.maletas;
        pasajero.flag = p.flag;
        return pasajero;
    }
    */
    private void randomDocumentos(){
    int min = 1;
    int max = 10;
    //ejecuta una funcion matematica para obtener aleatoriamente
    //el numero de turnos
    this.documentos = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
    private void randomMaletas(){
    int min = 1;
    int max = 4;
    //ejecuta una funcion matematica para obtener aleatoriamente
    //el numero de turnos
    this.maletas = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
    private void randomTurnos(){
        int min = 1;
        int max = 3;
        //ejecuta una funcion matematica para obtener aleatoriamente
        //el numero de turnos
        this.turnosRegistro = (int)(rand.nextDouble()*(max-min+1)) + min;
    }

    public int getDocumentos() {
        return documentos;
    }

    public int getId() {
        return id;
    }

    public int getTurnosRegistro() {
        return turnosRegistro;
    }

    public int getMaletas() {
        return maletas;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setTurnosRegistro(int turnosRegistro) {
        this.turnosRegistro = turnosRegistro;
    }
    
    
    
}
