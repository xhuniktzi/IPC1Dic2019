/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista;

import com.xhunik.controladores.App;
import com.xhunik.vista.eventsMenu.eventMostrarPedidos;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
    public static JTextField fieldBuscar;    
    public static boolean flagDialog;
    public VentanaVerPedidos() throws HeadlessException {
        super("Ver Pedidos");
        setSize(new Dimension(720,600));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Container content = getContentPane();
        content.add(new JLabel("Ver Pedidos:"),BorderLayout.NORTH);
        JPanel panelContent = new JPanel(null);
        content.add(panelContent,BorderLayout.CENTER);
        
        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSearch.setLocation(0,0);
        panelSearch.setSize(700,50);
        panelContent.add(panelSearch);       
        
        panelSearch.add(new JLabel("Buscar:"));
        fieldBuscar = new JTextField(30);
        panelSearch.add(fieldBuscar);
        JButton botonBuscar = new JButton("Buscar");
        //botonBuscar.addActionListener(new eventMostrarPedidos());
        panelSearch.add(botonBuscar);
        
        int n = 0;
        while (App.control.getGestor().getPedidosRealizados().getSize() > (n*n)){
            n++;
        }
        
        cuadriculaBotones = new GridLayout(n,n);
        
        panelMostrar = new JPanel();
        panelMostrar.setLayout(cuadriculaBotones);
        panelMostrar.setLocation(0, 70);
        panelMostrar.setSize(400,400);
        
        
        panelContent.add(panelMostrar);
        
        
        for (int i = 0; i < App.control.getGestor().getPedidosRealizados().getSize(); i++){
            panelMostrar.add(new BotonPedidos(App.control.getGestor().getPedidosRealizados().getPedidoByIndex(i).getId()));
        }
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                Ventana.flagVerPedidos = false;
                dispose();
            }
        });
    }
    
}

class BotonPedidos extends JButton {
    int id;
    public BotonPedidos(int id){
        super(String.valueOf(App.control.getGestor().getPedidosRealizados().searchPedidoByID(id).getId()));
        this.id = id;
        addActionListener(new eventMostrarPedidos(id));
    }
    
}