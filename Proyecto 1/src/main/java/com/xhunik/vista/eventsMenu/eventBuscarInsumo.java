/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.VentanaRegistroProducto;
import com.xhunik.vista.dialogs.DialogSearchInsumos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author xhunik
 */
public class eventBuscarInsumo implements ActionListener {
    public static DialogSearchInsumos dialog;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!VentanaRegistroProducto.flagDialog){
            dialog = new DialogSearchInsumos();
            dialog.setVisible(true);
            VentanaRegistroProducto.flagDialog = true;
        }
    }
    
}