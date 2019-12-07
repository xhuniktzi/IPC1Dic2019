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
public class Aereopuerto {
    private int turnos;
    private int cantAviones;
    private int cantRegistro;
    private int filaRegistro;
    private int cantMantenimiento;
    private int filaMantenimiento;
    private boolean flag = false;
    
    private Pasajero[] listaPasajeros;
    private Avion[] listaAviones;
    private Maleta[] listaMaletas;
    
    private EscritorioRegistro[] areasRegistro;
    private EstacionServicio[] areasMantenimiento;
    
    public Aereopuerto(){/* Constructor vacio */}
    
    public void setEnv(int t, int cA, int cR, int fR, int cM, int fM){
        this.turnos = t;
        this.cantAviones = cA;
        this.cantRegistro = cR;
        this.filaRegistro = fR;
        this.cantMantenimiento = cM;
        this.filaMantenimiento = fM;
        this.flag = true;
        
        
    }
    
    public boolean isExecute(){
        return this.flag;
    }
    
    public void execute(){
        
    }
}

