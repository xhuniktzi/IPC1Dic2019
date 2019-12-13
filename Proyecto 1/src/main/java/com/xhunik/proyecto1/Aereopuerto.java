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
    
    String str = "";
    
    //atributos del areopuerto
    int turnos;
    int cantAviones;
    int cantEscritoriosRegistro;
    int sizeFilaRegistro;
    int cantEstacionesServicio;
    int sizeFilaServicio;
    
    Pasajero colaPasajeros[][];
    Avion avionParaEnviarMantenimiento;
    Avion colaAviones[][];
    Maleta colaMaletas[];
    
    
    boolean avionDesabordando;
    int turnosOcupadosDesabordando;
    int avionesDesabordados;
    
    int longitudMaletas;
    int apuntadorMaletas;
    
    //int contadorMaletas;
    //int mediaDeUIDS;

    public Aereopuerto() {/*Vacio*/}
    
    public Aereopuerto(
            int turnos,
            int cantAviones,
            int cantEscritoriosRegistro,
            int sizeFilaRegistro,
            int cantEstacionesServicio,
            int sizeFilaServicio
    ){
        this.turnos = turnos;
        this.cantAviones = cantAviones;
        this.cantEscritoriosRegistro = cantEscritoriosRegistro;
        this.sizeFilaRegistro = sizeFilaRegistro;
        this.cantEstacionesServicio = cantEstacionesServicio;
        this.sizeFilaServicio = sizeFilaServicio;
        
        this.longitudMaletas = cantAviones*36*3;
        this.apuntadorMaletas = 0;
        
        avionDesabordando = false;
        
        colaPasajeros = new Pasajero[cantEscritoriosRegistro][sizeFilaRegistro];
        for (int i = 0; i<cantEscritoriosRegistro;i++){
            for (int j = 0; j < sizeFilaRegistro;j++){
                colaPasajeros[i][j] = new Pasajero(false);
            }
        }
        
        colaAviones = new Avion[cantEstacionesServicio][sizeFilaServicio];
        for (int i = 0; i<cantEstacionesServicio;i++){
            for (int j = 0; j < sizeFilaServicio;j++){
                colaAviones[i][j] = new Avion(false);
            }
        }
        
        colaMaletas = new Maleta[longitudMaletas];
        for (int i = 0; i < longitudMaletas;i++){
            colaMaletas[i] = new Maleta(false);
        }
        
    }

    public void execute(){
        if (turnos > 0){
            turnos--;
            
            //muestra el estado de las colas de pasajeros
            message("**************************\n");
            message("\t Flujo de Colas del Registro de Pasajeros\n");
            message("**************************\n");
            message("Id del pasajero : Id Turnos Restantes\n");
            for (int j = 0; j < sizeFilaRegistro;j++){
                for (int i = 0; i <cantEscritoriosRegistro;i++){
                    System.out.print("\t" + colaPasajeros[i][j].getId() + ":" + colaPasajeros[i][j].getTurnosRegistro());
                    message("\t" + colaPasajeros[i][j].getId() + ":" + colaPasajeros[i][j].getTurnosRegistro());
                }
                    System.out.print("\n");
                    message("\n");
                }
            message("**************************\n");
            message("\t Estado de los Escritorios de Registro\n");
            message("**************************\n");
            for (int i = 0; i < cantEscritoriosRegistro;i++){
                message("**************************\n");
                message("Escritorio: " + (i+1) + "\n");
                message("Atendiendo a: " + colaPasajeros[i][0].getId() + "\n");
                message("Turnos Restantes: " + colaPasajeros[i][0].getTurnosRegistro() + "\n");
                message("Documentos a revisar: " + colaPasajeros[i][0].getDocumentos() + "\n");
                message("**************************\n");
            }

            //muestra estado de las maletas
            
            
            //muestra el estade mantenimiento
            System.out.println("Estado de la cola de aviones");
            message("**************************\n");
            message("\t Estado de las colas de Estaciones de Mantenimiento\n");
            message("**************************\n");
            message("Id del avion : Id Turnos Restantes\n");
            
            for (int j = 0; j < sizeFilaServicio;j++){
                for (int i = 0; i <cantEstacionesServicio;i++){
                    System.out.print("\t" + colaAviones[i][j].getId() + ":" + colaAviones[i][j].getTurnosMantenimiento());
                    message("\t" + colaAviones[i][j].getId() + ":" + colaAviones[i][j].getTurnosMantenimiento());
                }
                    System.out.print("\n");
                    message("\n");
            }
            message("**************************\n");
            message("\tEstado de las Estaciones de Mantenimiento\n");
            message("**************************\n");
            for (int i = 0; i < cantEstacionesServicio;i++){
                message("**************************\n");
                message("Estacion: " + (i+1) + "\n");
                message("Atendiendo a: " + colaAviones[i][0].getId() + "\n");
                message("Turnos Restantes: " + colaAviones[i][0].getTurnosMantenimiento() + "\n");
                message("**************************\n");
            }
            message("**************************\n");
            message("Estado de las maletas\n");
            message("**************************\n");
            for (int i = 0; i < apuntadorMaletas;i++){
                message(colaMaletas[i].getIdMaleta() + "-" + colaMaletas[i].getIdPasajero()+ "\n");
            }
                message("**************************\n");
            
            //ejecutar corrimiento de las colas
            for (int i = 0; i < cantEscritoriosRegistro; i++){
                if (colaPasajeros[i][0].isFlag()){
                    if (colaPasajeros[i][0].getTurnosRegistro() > 0){
                        colaPasajeros[i][0].setTurnosRegistro(colaPasajeros[i][0].getTurnosRegistro()-1);
                    }
                    else {
                        //invocar funcion de desplazamiento
                        searchAndDelMaletasById(colaPasajeros[i][0].getId());
                        moveOneItemPasajero(i);
                        
                        //mediaDeMaletasUID();
                        //ordenarQuickSortMaletas(colaMaletas,0,apuntadorMaletas );
                    }
                }
            }
            //ejecutar corrimiento de las colas
            for (int i = 0; i < cantEstacionesServicio; i++){
                if (colaAviones[i][0].isFlag()){
                    if (colaAviones[i][0].getTurnosMantenimiento()> 0){
                        colaAviones[i][0].setTurnosMantenimiento(colaAviones[i][0].getTurnosMantenimiento()-1);
                    }
                    else {
                        //invocar funcion de desplazamiento
                        moveOneItemAvion(i);
                    }
                }
            }
            
            if (cantAviones > avionesDesabordados){
                if (!avionDesabordando){
                    Avion a = new Avion();
                    turnosOcupadosDesabordando = a.getTurnosDesabordaje();
                    message("**************************\n\n");
                    System.out.println("\n\tAvion numero: " + a.getId() + "\n");
                    message("Avion numero: " + a.getId() + "\n");
                    System.out.println("Desabordando avion " + a.getId() + " en: " + turnosOcupadosDesabordando + " turnos mas");
                    message("Desabordando avion " + a.getId() + " en: " + turnosOcupadosDesabordando + " turnos mas" + "\n");
                    System.out.println("Pasajeros a bordo: " + a.getCantPasajeros());
                    message("Pasajeros a bordo: " + a.getCantPasajeros() + "\n");
                    System.out.println("Tipo de avion: "+ a.getTipo());
                    message("Tipo de avion: "+ a.getTipo() + "\n\n");
                    message("**************************\n");
                    avionDesabordando = true;
                    
                    
                    //generar pasajeros y maletas de pasajeros
                    for (int i=0; i < a.getCantPasajeros();i++){
                        Pasajero p = new Pasajero();
                        addColaPasajeros(p);
                        //System.out.println("Pasajero: " + p.getId() + "->" + p.getMaletas());
                        
                        for (int j = 0; j < p.getMaletas();j++){
                            Maleta m = new Maleta((j+1), p.getId());
                            addColaMaletas(m);
                        }
                    }
                    
                    System.out.println("Estado de la cola de Maletas");
                    message("**************************\n");
                    message("\t Estado de las maletas\n");
                    message("**************************\n");
                    if (apuntadorMaletas == 0){
                        System.out.println("No hay maletas en el sistema");
                        message("No hay maletas en el sistema\n");
                    }
                    else {
                        message("Actualmente hay: " + apuntadorMaletas /*contadorMaletas*/ + " maletas en el sistema\n");
                        System.out.println("Actualmente hay: " + apuntadorMaletas /* contadorMaletas */ + " maletas en el sistema\n");
                        for (int i = 0; i < apuntadorMaletas;i++){
                            System.out.println("\tUID:" + colaMaletas[i].getUID());
                        }
                    }
                    message("**************************\n");
                    message("Maleta: id - id del pasajero\n");
                    message("Cola de maletas antes de aplicar ordenamiento\n");
                    for (int i = 0; i < apuntadorMaletas;i++){
                        message (colaMaletas[i].getIdMaleta() + "-" + colaMaletas[i].getIdPasajero()+ "\n");
                    }
                    ordenarBurbujaMaletas();
                    
                    while (colaMaletas[0].getUID() == 0){
                        moveOneItemMaleta();
                    }
                    
                    apuntadorMaletas++;
                    message("Maletas ordenadas segun Pasajero y id\n");
                    for (int i = 0; i < apuntadorMaletas;i++){
                        message(colaMaletas[i].getIdMaleta() + "-" + colaMaletas[i].getIdPasajero()+ "\n");
                    }
                    message("**************************\n");
                    //mediaDeMaletasUID();
                    //guardar datos utiles para mantenimiento
                    avionParaEnviarMantenimiento = a;
                    
                    //turnos        
                    turnosOcupadosDesabordando--;
                    
                }
                else{
                    
                    if (turnosOcupadosDesabordando == 0){
                        turnosOcupadosDesabordando--;
                        avionDesabordando = false;
                        avionesDesabordados++;
                        System.out.println("Avion " + avionParaEnviarMantenimiento.getId() + " enviado a mantenimiento\n");
                        message("Avion " + avionParaEnviarMantenimiento.getId() + " enviado a mantenimiento\n");
                        //enviar a mantenimiento
                        addColaAviones(avionParaEnviarMantenimiento);
                        
                    }
                    else {
                        System.out.println("Desabordando en: " + turnosOcupadosDesabordando + " turnos mas");
                        message("Desabordando avion " + avionParaEnviarMantenimiento.getId() + " en: " + turnosOcupadosDesabordando + " turnos mas\n");
                        turnosOcupadosDesabordando--;
                    }
                }
            }
            //despues de aviones
            /*
            if (apuntadorMaletas > 0){
                moveOneItemMaleta();
            }
            */
        }
        else {
            System.out.println("no hay mas turnos");
        }
    }
    
    public int getTurnos() {
        return turnos;
    }
    public boolean addColaPasajeros(Pasajero p){
        for (int j = 0; j < sizeFilaRegistro; j++){
            for (int i = 0; i < cantEscritoriosRegistro;i++){
                if (!colaPasajeros[i][j].isFlag()){
                    colaPasajeros[i][j] = p;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean addColaAviones(Avion a){
        for (int j = 0; j < sizeFilaServicio; j++){
            for (int i = 0; i < cantEstacionesServicio;i++){
                if (!colaAviones[i][j].isFlag()){
                    colaAviones[i][j] = a;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean addColaMaletas(Maleta m){

        for (int i = 0; i < longitudMaletas;i++){
            if (!colaMaletas[i].isFlag()){
                colaMaletas[i] = m;
                apuntadorMaletas++;
                //contadorMaletas++;
                return true;
            }
        }
        return false;
    }

    
    public void moveOneItemPasajero(int indexPosition){
        Pasajero pasajeroVacio = new Pasajero(false);
        for (int i = 0; i < sizeFilaRegistro; i++){
            if (i < (sizeFilaRegistro-1)){
                colaPasajeros[indexPosition][i] = colaPasajeros[indexPosition][i+1];
            }
            else {
                colaPasajeros[indexPosition][i] = pasajeroVacio;
            }
        }
    }
    
    public void moveOneItemAvion(int indexPosition){
        Avion avionVacio = new Avion(false);
        for (int i = 0; i < sizeFilaServicio; i++){
            if (i < (sizeFilaServicio-1)){
                colaAviones[indexPosition][i] = colaAviones[indexPosition][i+1];
            }
            else {
                colaAviones[indexPosition][i] = avionVacio;
            }
        }
    }
    
    public void moveOneItemMaleta(){
        Maleta maletaVacia = new Maleta(false);
           for (int i = 0; i < apuntadorMaletas; i++){
            if (i < (apuntadorMaletas)){
                colaMaletas[i] = colaMaletas[i+1];
                
            }
            else {
                colaMaletas[i] = maletaVacia;
            }
        }
        apuntadorMaletas--;
    }
    
    
    
    public void searchAndDelMaletasById(int id){
        Maleta maletaVacia = new Maleta(false);
        for (int i = 0; i <= apuntadorMaletas; i++){
            if (colaMaletas[i].getIdPasajero() == id){
                colaMaletas[i] = maletaVacia;
                //apuntadorMaletas--;
                
                //contadorMaletas--;
            }
        }
    }
    
    public void ordenarBurbujaMaletas(){
        for (int i = 0; i < apuntadorMaletas;i++){
            for (int j = 0; j < apuntadorMaletas; j++){
                if (colaMaletas[j].getUID() > colaMaletas[j+1].getUID()){
                    Maleta maletaTemporal = new Maleta(false);
                    maletaTemporal = colaMaletas[j];
                    colaMaletas[j] = colaMaletas[j+1];
                    colaMaletas[j+1] = maletaTemporal;
                }
            }
        }
    }

    /*
    public void ordenarQuickSortMaletas(Maleta vec[],int inicio, int fin){
       if (inicio >= fin){
           return;
       }
       int pivote = vec[inicio].getUID();
       int left = inicio+1;
       int right = fin;
       while (left <= right){
           while (left <= fin && vec[left].getUID() < pivote){
               left++;
           }
           while (right > inicio && vec[right].getUID() >= pivote){
               right--;
           }
           if (right < left){
               Maleta maletaTemporal = new Maleta(false);
               maletaTemporal = vec[left];
               vec[left] = vec[right];
               vec[right] = maletaTemporal;
           }
       }
       if (right > inicio){
           Maleta maletaTemporal = new Maleta(false);
           maletaTemporal = vec[inicio];
           vec[inicio] = vec[right];
           vec[right] = maletaTemporal;
       }
       
        ordenarQuickSortMaletas(vec,inicio, right-1);
        ordenarQuickSortMaletas(vec, right+1, fin);
    }
    */
    
    /*
    public void mediaDeMaletasUID(){
        int sumaUIDS = 0;
        int prom = 0;
        for (int i = 0; i < apuntadorMaletas+1; i++){
            sumaUIDS += colaMaletas[i].getUID();
        }
       prom = sumaUIDS/apuntadorMaletas;
       this.mediaDeUIDS = prom;
    }
    */
    public String getMessage(){
        return str;
    }
    
    public void message(String string){
        str += string;
    }
    
    public void clearMessage(){
        str = "";
    }
}