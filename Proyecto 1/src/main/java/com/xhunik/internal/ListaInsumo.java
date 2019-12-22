/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.internal;

/**
 *
 * @author xhunik
 */

//implementa pseudoMemoriaDinamica
public class ListaInsumo {
    private Insumo[] listadoInsumos;
    private int punteroArray;
    private int longArray;

    public ListaInsumo(int size) {
        punteroArray = 0;
        longArray = size;
        listadoInsumos = new Insumo[size];
        for (int i = 0; i<listadoInsumos.length;i++){
            listadoInsumos[i] = new Insumo();
        }
    }
    public void addInsumo(Insumo insumo){
        if (longArray > punteroArray){
            this.listadoInsumos[punteroArray] = insumo;
            punteroArray++;
        }
        else {
            Insumo[] temporalInsumos = new Insumo[longArray];
            for (int i = 0; i < temporalInsumos.length;i++){
                temporalInsumos[i] = new Insumo();
            }
            for (int i = 0; i < longArray; i++){
                temporalInsumos[i] = listadoInsumos[i];
            }
            longArray = longArray+1;
            listadoInsumos = new Insumo[longArray];
            for (int i = 0; i < listadoInsumos.length;i++){
                listadoInsumos[i] = new Insumo();
            }
            for (int i = 0; i < punteroArray; i++){
                listadoInsumos[i] = temporalInsumos[i];
            }
            this.listadoInsumos[punteroArray] = insumo;
            punteroArray++;
        }
    }

    public int getSize(){
        return longArray;
    }
    
    public Insumo getInsumoByIndex(int index){
        return listadoInsumos[index];
    }
    
    public ListaInsumo searchInsumosByNombre(String nombre){
        ListaInsumo listaTemporal = new ListaInsumo(this.getSize());
        ListaInsumo listaRetorno;
        int contadorCoincidencias = 0;
        for (int i = 0; i < this.getSize();i++){
            String[] palabras = nombre.split("\\s+");
            for (String palabra : palabras) {
                if (listadoInsumos[i].getNombre().contains(palabra)) {
                    System.out.println("Encontrado");
                    listaTemporal.addInsumo(listadoInsumos[i]);
                    contadorCoincidencias++;
                }
            }
        }
        listaRetorno = new ListaInsumo(contadorCoincidencias);
        for (int i = 0; i < contadorCoincidencias;i++ ){
            if (listaTemporal.getInsumoByIndex(i).isFlag()){
                listaRetorno.addInsumo(listaTemporal.getInsumoByIndex(i));
            }
        }
        return listaRetorno;
    }
    
    public boolean existsInsumoId(int id){
         for (int i = 0; i < this.getSize();i++){
            if (listadoInsumos[i].getId() == id){
                return true;
            }
        }
        return false;
    }
    
    public Insumo searchInsumoByID(int id){
        Insumo insumoRetorno = new Insumo();
        for (int i = 0; i < this.getSize();i++){
            if (listadoInsumos[i].getId() == id){
                insumoRetorno = listadoInsumos[i];
            }
        }
        return insumoRetorno;
    }

    public void setListadoInsumos(Insumo[] listadoInsumos) {
        this.listadoInsumos = listadoInsumos;
    }

    public void setLongArray(int longArray) {
        this.longArray = longArray;
    }

    public void setPunteroArray(int punteroArray) {
        this.punteroArray = punteroArray;
    }
    public ListaInsumo copiaListaInsumo(){
        ListaInsumo list = new ListaInsumo(1);
        for (int i = 0; i < getSize();i++){
            list.addInsumo(getInsumoByIndex(i));
        }
        return list;
    }
    @Override
    public String toString() {
        String temporalStr = ""; 
        for (Insumo i: listadoInsumos){
            temporalStr += i + "\n";
        }
        return temporalStr;
    }
    
}
