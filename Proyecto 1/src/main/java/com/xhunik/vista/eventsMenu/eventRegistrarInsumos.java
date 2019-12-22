/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.Ventana;
import com.xhunik.vista.VentanaRegistroInsumo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author xhunik
 */
public class eventRegistrarInsumos implements ActionListener{
    public static VentanaRegistroInsumo ventanaRegistro;
    @Override
    public void actionPerformed(ActionEvent e){
        if (!Ventana.flagRegistrarInsumos){
            System.out.println("Insumo Registrado");
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ventanaRegistro = new VentanaRegistroInsumo();
                ventanaRegistro.setVisible(true);
            }
        });
            Ventana.flagRegistrarInsumos = true;
        }
    }
}
