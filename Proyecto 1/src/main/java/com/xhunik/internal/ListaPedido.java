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
public class ListaPedido {
    private Pedido[] listadoPedidos;
    private int punteroArray;
    private int longArray;

    public ListaPedido(int size) {
        punteroArray = 0;
        longArray = size;
        listadoPedidos = new Pedido[size];
        for (int i = 0; i<listadoPedidos.length;i++){
            listadoPedidos[i] = new Pedido();
        }
    }
    public void addPedido(Pedido pedido){
        if (longArray > punteroArray){
            this.listadoPedidos[punteroArray] = pedido;
            punteroArray++;
        }
        else {
            Pedido[] temporalPedidos = new Pedido[longArray];
            for (int i = 0; i < temporalPedidos.length;i++){
                temporalPedidos[i] = new Pedido();
            }
            for (int i = 0; i < longArray; i++){
                temporalPedidos[i] = listadoPedidos[i];
            }
            longArray = longArray+1;
            listadoPedidos = new Pedido[longArray];
            for (int i = 0; i < listadoPedidos.length;i++){
                listadoPedidos[i] = new Pedido();
            }
            for (int i = 0; i < punteroArray; i++){
                listadoPedidos[i] = temporalPedidos[i];
            }
            this.listadoPedidos[punteroArray] = pedido;
            punteroArray++;
        }
    }

    public int getSize(){
        return longArray;
    }
    
    public Pedido getPedidoByIndex(int index){
        return listadoPedidos[index];
    }
    
    public boolean existsPedidoId(int id){
         for (int i = 0; i < this.getSize();i++){
            if (listadoPedidos[i].getId() == id){
                return true;
            }
        }
        return false;
    }
    
    public Pedido searchPedidoByID(int id){
        Pedido pedidoRetorno = new Pedido();
        for (int i = 0; i < this.getSize();i++){
            if (listadoPedidos[i].getId() == id){
                pedidoRetorno = listadoPedidos[i];
            }
        }
        return pedidoRetorno;
    }
    
    @Override
    public String toString() {
        String temporalStr = ""; 
        for (Pedido p: listadoPedidos){
            temporalStr += p + "\n";
        }
        return temporalStr;
    }
    
}
