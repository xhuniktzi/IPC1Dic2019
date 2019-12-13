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
    private static int idContador = 0;
    
    private int id;
    private Random rand;
    private TipoAvion tipo;
    private int cantPasajeros;
    private int turnosDesabordaje;
    private int turnosMantenimiento;
    private boolean flag;
    
    public Avion() {
        rand = new Random();
        tipo = randomTipo();
        randomCantPasajeros();
        if (tipo == TipoAvion.small)
            turnosDesabordaje = 1;
        if (tipo == TipoAvion.medium)
            turnosDesabordaje = 2;
        if (tipo == TipoAvion.big)
            turnosDesabordaje = 3;
        randomTurnosMantenimiento();
        idContador++;
        id = idContador;
        flag = true;
    }

    public Avion(Avion a){
        id = a.id;
        cantPasajeros = a.cantPasajeros;
        turnosDesabordaje = a.turnosDesabordaje;
        turnosMantenimiento = a.turnosMantenimiento;
        flag = a.flag;
    }
    
    public Avion(boolean bool){
        id = 0;
        cantPasajeros = 0;
        turnosDesabordaje = 0;
        turnosMantenimiento = 0;
        flag = bool;
    }
    /*
    public void copiaAvion(Avion a){
        Avion av = new Avion();
        cantPasajeros = av.cantPasajeros;
        turnosDesabordaje = av.turnosDesabordaje;
        turnosMantenimiento = av.turnosMantenimiento;
        flag = av.flag;
    }
    */
    public int getId() {
        return id;
    }
    
    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public int getTurnosDesabordaje() {
        return turnosDesabordaje;
    }
    
    private TipoAvion randomTipo(){
        double randomDouble = rand.nextDouble();
        if (randomDouble >= 0 && randomDouble <= 0.25)
            return TipoAvion.small;
        if (randomDouble > 0.25 && randomDouble < 0.55)
            return TipoAvion.medium;
        if (randomDouble >= 0.55 && randomDouble <= 1)
            return TipoAvion.big;
        return null;
    }

    public int getTurnosMantenimiento() {
        return turnosMantenimiento;
    }

    public void setTurnosMantenimiento(int turnosMantenimiento) {
        this.turnosMantenimiento = turnosMantenimiento;
    }

    public boolean isFlag() {
        return flag;
    }

    public TipoAvion getTipo() {
        return tipo;
    }
    
    
    
    private void randomCantPasajeros(){
        int min = 0;
        int max = 0;
        if (this.tipo == TipoAvion.small){
            min = 5;
            max = 10;
        }
        if (this.tipo == TipoAvion.medium){
            min = 15;
            max = 25;
        }
        if (this.tipo == TipoAvion.big){
            min = 30;
            max = 40;
        }
        //ejecuta una funcion matematica para obtener aleatoriamente
        //la cantidad de pasajeros
        this.cantPasajeros = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
    private void randomTurnosMantenimiento(){
         //fijar los rangos segun el tipo de avion
        int min = 0;
        int max = 0;
        if (this.tipo == TipoAvion.small){
            min = 1;
            max = 3;
        }
        if (this.tipo == TipoAvion.medium){
            min = 2;
            max = 4;
        }
        if (this.tipo == TipoAvion.big){
            min = 3;
            max = 6;
        }
        //ejecuta una funcion matematica para obtener aleatoriamente
        //el numero de turnos
        this.turnosMantenimiento = (int)(rand.nextDouble()*(max-min+1)) + min;
    }
}
enum TipoAvion{
    small,medium,big;
    
    @Override
    public String toString() {
        switch (this){
            case small: return "pequeño";
            case medium: return "mediano";
            case big: return "grande";
        }
        return null;
    }
}