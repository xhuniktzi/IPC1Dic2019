/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.Ventana;
import com.xhunik.vista.VentanaReabastecerInsumos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author xhunik
 */
public class eventReabastecerInsumos implements ActionListener{
    public VentanaReabastecerInsumos ventanaReabastecerInsumos;
    @Override
    public void actionPerformed(ActionEvent e){
        if (!Ventana.flagReabastecerInsumos){
            System.out.println("Insumo Reabastecido");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ventanaReabastecerInsumos = new VentanaReabastecerInsumos();
                    ventanaReabastecerInsumos.setVisible(true);
                }
            });
            Ventana.flagReabastecerInsumos = true;
        }
    }
}
