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
    
    //contiene la lista de pasajeros que van a ingresar a las colas
    private Pasajero[] listaPasajeros; 
    //contiene la lista de aviones por llegar
    private Avion[] listaAviones;
    //contiene las maletas de los pasajeros registrados, aplicar ordenamiento
    private Maleta[] listaMaletas;
    
    //cola de las areas de registro
    private EscritorioRegistro[] areasRegistro;
    //cola de las areas de mantenimiento
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
        this.listaAviones = new Avion[this.cantAviones];
        this.initColas();
        this.initAviones();
        //codigo a ejecutar en el inicio
        
        //fin codigo a ejecutar durante el inicio
    }
    
    public boolean isExecute(){
        return this.flag;
    }
    
    public void execute(){
        if (this.turnos > 0){
            
            //codigo a ejecutar en cada paso
            
            //fin codigo a ejecutar en cada paso
            this.turnos--;
            
        }
        else {
            
            this.flag=false;
        }
    }
    
   
    
    private void initColas(){
        int i;
        this.areasMantenimiento = new EstacionServicio[this.cantMantenimiento];
        this.areasRegistro = new EscritorioRegistro[this.cantRegistro];
        for (i = 0;i < this.areasMantenimiento.length;i++){
            this.areasMantenimiento[i] = new EstacionServicio(this.filaMantenimiento);
        }
        for (i = 0;i < this.areasRegistro.length;i++){
            this.areasRegistro[i] = new EscritorioRegistro(this.filaRegistro);
        }
            
    }
    private void initAviones(){
        int i;
        for (i = 0; i < this.listaAviones.length; i++){
            this.listaAviones[i] = new Avion();
            
        }
    }
}

