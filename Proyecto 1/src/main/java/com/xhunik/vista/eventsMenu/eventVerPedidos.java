/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.Ventana;
import com.xhunik.vista.VentanaVerPedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author xhunik
 */
public class eventVerPedidos implements ActionListener{
    public VentanaVerPedidos ventanaPedidos;
    @Override
    public void actionPerformed(ActionEvent e){
        if (!Ventana.flagVerPedidos){
            System.out.println("Accion -> Ver Pedidos");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ventanaPedidos = new VentanaVerPedidos();
                    ventanaPedidos.setVisible(true);
                }
            });
            Ventana.flagVerPedidos = true;
        }
    }
}
