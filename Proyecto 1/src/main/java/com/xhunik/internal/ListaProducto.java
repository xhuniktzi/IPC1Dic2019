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
public class ListaProducto {
    private Producto[] listadoProductos;
    private int punteroArray;
    private int longArray;

    public ListaProducto(int size) {
        punteroArray = 0;
        longArray = size;
        listadoProductos = new Producto[size];
        for (int i = 0; i<listadoProductos.length;i++){
            listadoProductos[i] = new Producto();
        }
    }
    public void addProducto(Producto producto){
        if (longArray > punteroArray){
            producto.setFlag(true);
            this.listadoProductos[punteroArray] = producto;
            punteroArray++;
        }
        else {
            Producto[] temporalProductos = new Producto[longArray];
            for (int i = 0; i < temporalProductos.length;i++){
                temporalProductos[i] = new Producto();
            }
            for (int i = 0; i < longArray; i++){
                temporalProductos[i] = listadoProductos[i];
            }
            longArray = longArray+1;
            listadoProductos = new Producto[longArray];
            for (int i = 0; i < listadoProductos.length;i++){
                listadoProductos[i] = new Producto();
            }
            for (int i = 0; i < punteroArray; i++){
                listadoProductos[i] = temporalProductos[i];
            }
            producto.setFlag(true);
            this.listadoProductos[punteroArray] = producto;
            punteroArray++;
        }
    }

    public int getSize(){
        return longArray;
    }
    
    public Producto getProductoByIndex(int index){
        return listadoProductos[index];
    }
    
    public ListaProducto searchProductosByNombre(String nombre){
        ListaProducto listaTemporal = new ListaProducto(this.getSize());
        ListaProducto listaRetorno;
        int contadorCoincidencias = 0;
        for (int i = 0; i < this.getSize();i++){
            String[] palabras = nombre.split("\\s+");
            for (String palabra : palabras) {
                if (listadoProductos[i].getNombre().contains(palabra)) {
                    System.out.println("Encontrado");
                    listaTemporal.addProducto(listadoProductos[i]);
                    contadorCoincidencias++;
                }
            }
        }
        listaRetorno = new ListaProducto(contadorCoincidencias);
        for (int i = 0; i < contadorCoincidencias;i++ ){
            if (listaTemporal.getProductoByIndex(i).isFlag()){
                listaRetorno.addProducto(listaTemporal.getProductoByIndex(i));
            }
        }
        return listaRetorno;
    }
    
    public boolean existsProductoId(int id){
         for (int i = 0; i < this.getSize();i++){
            if (listadoProductos[i].getId() == id){
                return true;
            }
        }
        return false;
    }
    
    public Producto searchProductoByID(int id){
        Producto productoRetorno = new Producto();
        for (int i = 0; i < this.getSize();i++){
            if (listadoProductos[i].getId() == id){
                productoRetorno = listadoProductos[i];
            }
        }
        return productoRetorno;
    }

    public void setListadoProductos(Producto[] listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

    public Producto[] getListadoProductos() {
        return listadoProductos;
    }
    
    
    
    public ListaProducto sortSelectionAscendentAlphabet(){
        int n;
        ListaProducto lista = new ListaProducto(1);
        Producto[] p = getListadoProductos();
        
        for (int i = 1; i < getSize(); i++ ){
            Producto aux = p[i];
            n = i;
            while (n > 0 && p[n-1].getNombre().compareTo(aux.getNombre())>0){
                p[n] = p[n-1];
                --n;
            }
            p[n] = aux;
        }
        for (int i = 0; i < p.length;i++ ){
            lista.addProducto(p[i]);
        }
        return lista;
    }
    
    public ListaProducto sortSelectionInvAlphabet(){
        int n;
        ListaProducto lista = new ListaProducto(1);
        Producto[] p = getListadoProductos();
        
        for (int i = 1; i < getSize(); i++ ){
            Producto aux = p[i];
            n = i;
            while (n > 0 && p[n-1].getNombre().compareTo(aux.getNombre())<0){
                p[n] = p[n-1];
                --n;
            }
            p[n] = aux;
        }
        for (int i = 0; i < p.length;i++ ){
            lista.addProducto(p[i]);
        }
        return lista;
    }
    
    public ListaProducto sortSelectionAscendentPrecio(){
        int n;
        ListaProducto lista = new ListaProducto(1);
        Producto[] p = getListadoProductos();
        
        for (int i = 1; i < getSize(); i++ ){
            Producto aux = p[i];
            n = i;
            while (n > 0 && p[n-1].getPrecio() > aux.getPrecio()){
                p[n] = p[n-1];
                --n;
            }
            p[n] = aux;
        }
        for (int i = 0; i < p.length;i++ ){
            lista.addProducto(p[i]);
        }
        return lista;
    }
    
    public ListaProducto sortSelectionInvPrecio(){
        int n;
        ListaProducto lista = new ListaProducto(1);
        Producto[] p = getListadoProductos();
        
        for (int i = 1; i < getSize(); i++ ){
            Producto aux = p[i];
            n = i;
            while (n > 0 && p[n-1].getPrecio() < aux.getPrecio()){
                p[n] = p[n-1];
                --n;
            }
            p[n] = aux;
        }
        for (int i = 0; i < p.length;i++ ){
            lista.addProducto(p[i]);
        }
        return lista;
    }
    
    public ListaProducto sortBurbujaAscendNombre(){
        Producto[] p = getListadoProductos();
        ListaProducto lista = new ListaProducto(1);
        for (int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize()-1;j++){
                if (p[j].getNombre().compareTo(p[j+1].getNombre())> 0) {
                    Producto tmp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = tmp;
                    
                }
            }
        }
        for (int i = 0; i < p.length;i++){
            lista.addProducto(p[i]);
        }
        return lista;
    }
    public ListaProducto sortBurbujaInvNombre(){
        Producto[] p = getListadoProductos();
        ListaProducto lista = new ListaProducto(1);
        for (int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize()-1;j++){
                if (p[j].getNombre().compareTo(p[j+1].getNombre())< 0) {
                    Producto tmp = p[j+1];
                    p[j+1] = p[j];
                    p[j] = tmp;
                    
                }
            }
        }
        for (int i = 0; i < p.length;i++){
            lista.addProducto(p[i]);
        }
        return lista;
    }
    
    public ListaProducto sortBurbujaInvPrecio(){
        Producto[] p = getListadoProductos();
        ListaProducto lista = new ListaProducto(1);
        for (int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize()-1;j++){
                if (p[j].getPrecio() < p[j+1].getPrecio()) {
                    Producto tmp = p[j+1];
                    p[j+1] = p[j];
                    p[j] = tmp;
                    
                }
            }
        }
        for (int i = 0; i < p.length;i++){
            lista.addProducto(p[i]);
        }
        return lista;
    }
    
    public ListaProducto sortBurbujaAscendPrecio(){
        Producto[] p = getListadoProductos();
        ListaProducto lista = new ListaProducto(1);
        for (int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize()-1;j++){
                if (p[j].getPrecio() > p[j+1].getPrecio()) {
                    Producto tmp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < p.length;i++){
            lista.addProducto(p[i]);
        }
        return lista;
    }
    
    @Override
    public String toString() {
        String temporalStr = ""; 
        for (Producto p: listadoProductos){
            temporalStr += p + "\n";
        }
        return temporalStr;
    }
    
}
