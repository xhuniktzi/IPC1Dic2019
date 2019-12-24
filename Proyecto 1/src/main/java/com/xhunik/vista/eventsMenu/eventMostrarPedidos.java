/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.dialogs.DialogMostrarPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author xhunik
 */
public class eventMostrarPedidos implements ActionListener{
    public int id;
    public static boolean flagDialog;
    public static DialogMostrarPedido dialog;
    public eventMostrarPedidos(int id){
        this.id = id;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //dialogo de informacion del pedido
        if (!flagDialog){
            dialog = new DialogMostrarPedido(id);
            dialog.setVisible(true);
            flagDialog = true;
        }
        
    }
    
}