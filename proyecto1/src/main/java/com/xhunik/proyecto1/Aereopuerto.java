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
    
    public Aereopuerto(int t, int cA, int cR, int fR, int cM, int fM){
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

class EscritorioRegistro{
    private int idCliente;
    private char id;
    private boolean status;
    private int cantDocuments;
    private int turnos;
    
    public EscritorioRegistro(Pasajero p){
        this.idCliente = p.getId();
        this.cantDocuments = p.getCantidadDocumentos();
        this.turnos = p.getTurnosRegistro();
    }
    
    public void ejecutarTurno(){
        if (this.turnos > 0){
            this.turnos--;
            this.status = true;
        }
        else
            this.status = false;
            
    }
}

class EstacionesServicio{
    int idAvion;
    boolean status;
    int turnosRestantes;
}