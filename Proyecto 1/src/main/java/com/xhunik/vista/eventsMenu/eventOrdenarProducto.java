/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.VentanaVender;
import com.xhunik.vista.dialogs.DialogOrdenarProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

/**
 *
 * @author xhunik
 */
public class eventOrdenarProducto implements ActionListener {
    public static JDialog dialog;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!VentanaVender.flagDialog2){
            dialog = new DialogOrdenarProductos();
            dialog.setVisible(true);
            VentanaVender.flagDialog2 = true;
        }
    }
    
}
