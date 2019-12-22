/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.eventsMenu;

import com.xhunik.vista.Ventana;
import com.xhunik.vista.VentanaRegistroProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author xhunik
 */
public class eventRegistrarProductos implements ActionListener{
    public static VentanaRegistroProducto ventanaRegistro;
    @Override
    public void actionPerformed(ActionEvent e){
        if (!Ventana.flagRegistrarProductos){
            System.out.println("Producto Registrado");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ventanaRegistro = new VentanaRegistroProducto();
                    ventanaRegistro.setVisible(true);
                }
            });
            Ventana.flagRegistrarProductos = true;
        }
    }
}
