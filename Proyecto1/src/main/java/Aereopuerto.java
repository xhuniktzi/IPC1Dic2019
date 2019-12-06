/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xhunik
 */

import java.util.Scanner;
import java.util.Random;

public class Aereopuerto {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int turnosFinalizar = sc.nextInt();
        int turnosCantidadAviones = sc.nextInt();
        int cantidadEscritorios = sc.nextInt();
        int tamañoFilas = sc.nextInt();
        int cantidadEstaciones = sc.nextInt();
        int tamañoFilaServicio = sc.nextInt();
        
    }
}

class Pasajero {
    private Random random = new Random();
    private int maletas;
    private int documentos;
    private int turnosRegistro;
}

class Avion{
    private Random random = new Random();
    private String tipoAvion;
    private int numeroPasajeros;
    private int turnosDesabordaje;
    private int turnosMantenimiento;
}

class EscritorioRegistro{
    private Random random = new Random();
    private char id;
    private int maxFila;
}
