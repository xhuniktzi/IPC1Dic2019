/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.Ventana;
import com.xhunik.vista.VentanaVender;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author xhunik
 */
public class eventVender implements ActionListener{
    public static VentanaVender ventanaVender;
    @Override
    public void actionPerformed(ActionEvent e){
        if (!Ventana.flagVender){
            System.out.println("Accion -> vender");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ventanaVender = new VentanaVender();
                    ventanaVender.setVisible(true);
                }
            });
            Ventana.flagVender = true;
        }
    }
}

