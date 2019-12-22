/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista;


import com.xhunik.controladores.App;
import static com.xhunik.vista.VentanaVender.cuadriculaBotones;
import static com.xhunik.vista.VentanaVender.panelMostrar;
import com.xhunik.vista.eventsMenu.eventBuscarProducto;
import com.xhunik.vista.eventsMenu.eventOrdenarProducto;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
/**
 *
 * @author xhunik
 */
public class VentanaVender extends JFrame {
    public static JTextField fieldBuscar;
    public static GridLayout cuadriculaBotones;
    public static JPanel panelMostrar;
    public static boolean flagDialog;
    public static boolean flagDialog2;
    public VentanaVender() throws HeadlessException {
        super("Vender");
        setSize(new Dimension(720,600));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Container content = getContentPane();
        content.add(new JLabel("Vender:"),BorderLayout.NORTH);
        JPanel panelContent = new JPanel();
        panelContent.setLayout(null);
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
        botonBuscar.addActionListener(new eventBuscarProducto());
        panelSearch.add(botonBuscar);
        JButton botonOrdenar = new JButton("Ordenar");
        botonOrdenar.addActionListener(new eventOrdenarProducto());
        panelSearch.add(botonOrdenar);
        
        int n = 0;
        while (App.control.getGestor().getProductosDisponibles().getSize() > (n*n)){
            n++;
        }
        
        cuadriculaBotones = new GridLayout(n,n);
        
        panelMostrar = new JPanel();
        panelMostrar.setLayout(cuadriculaBotones);
        panelMostrar.setLocation(0, 70);
        panelMostrar.setSize(400,400);
        
        
        panelContent.add(panelMostrar);
        
        
        for (int i = 0; i < App.control.getGestor().getProductosDisponibles().getSize(); i++){
            panelMostrar.add(new botonProducto(App.control.getGestor().getProductosDisponibles().getProductoByIndex(i).getId()));
        }
        
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                Ventana.flagVender = false;
                dispose();
            }
        });
    }
}
class botonProducto extends JButton {
    public botonProducto(int id){
        super(App.control.getGestor().getProductosDisponibles().searchProductoByID(id).getNombre());
        addActionListener(new eventoPulsarBoton(id));
    }
}
class eventoPulsarBoton implements ActionListener{
    int id;
    public eventoPulsarBoton(int id){
        this.id = id;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        App.control.executeSellById(id);
        Ventana.cantidadGanancias.setText(String.valueOf(App.control.getDinero()));
    }
    
}