/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.VentanaVerPedidos;
import com.xhunik.vista.dialogs.DialogSearchPedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author xhunik
 */
public class eventBuscarPedido implements ActionListener {
    //dialog
    public static DialogSearchPedidos dialog;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!VentanaVerPedidos.flagDialog2){
            dialog = new DialogSearchPedidos();
            dialog.setVisible(true);
            VentanaVerPedidos.flagDialog2 = true;
        }
    }
    
}
