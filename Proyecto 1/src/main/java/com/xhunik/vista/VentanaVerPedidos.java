/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
/**
 *
 * @author xhunik
 */
public class VentanaVerPedidos extends JFrame {
    public static GridLayout cuadriculaBotones;
    public static JPanel panelMostrar;
    public VentanaVerPedidos() throws HeadlessException {
        super("Ver Pedidos");
        setSize(new Dimension(720,600));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Container content = getContentPane();
        content.add(new JLabel("Ver Pedidos:"),BorderLayout.NORTH);
        JPanel panelContent = new JPanel(null);
        content.add(panelContent,BorderLayout.CENTER);
        
        
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                Ventana.flagVerPedidos = false;
                dispose();
            }
        });
    }
    
}