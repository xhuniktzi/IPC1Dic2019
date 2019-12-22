/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.VentanaVender;
import com.xhunik.vista.dialogs.DialogSearchProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author xhunik
 */
public class eventBuscarProducto implements ActionListener {
    public static DialogSearchProductos dialog;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!VentanaVender.flagDialog){
            dialog = new DialogSearchProductos();
            dialog.setVisible(true);
            VentanaVender.flagDialog = true;
        }
    }
    
}