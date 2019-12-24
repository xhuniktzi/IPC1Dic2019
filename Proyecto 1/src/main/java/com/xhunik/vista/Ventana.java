/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista;

import com.xhunik.controladores.App;
import com.xhunik.vista.eventsMenu.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author xhunik
 */
//Inicia Dibujado de Ventana 
public class Ventana extends JFrame {
    public static boolean flagRegistrarInsumos;
    public static boolean flagRegistrarProductos;
    public static boolean flagReabastecerInsumos;
    public static boolean flagVerPedidos;
    public static boolean flagVender;
    public static JTextField cantidadGanancias;
    public Ventana(){
        
        super("Manejo de Inventarios");
        Toolkit defaultTool = Toolkit.getDefaultToolkit();
        Dimension sizeScreen = defaultTool.getScreenSize();
        
        setSize(new Dimension(720,480));
        setLocation((sizeScreen.width/2)-360, (sizeScreen.height/2)-240);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        Container contenedor = this.getContentPane();
        
        JPanel panelMostrar = new JPanel();
        panelMostrar.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        
        JLabel tagGanancias = new JLabel("Ganancias Totales: ");
        panelMostrar.add(tagGanancias);
        cantidadGanancias = new JTextField(15);
        cantidadGanancias.setEditable(false);
        panelMostrar.add(cantidadGanancias);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(0,60, 720, 460);
        panelBotones.setLayout(null);
        
        JButton botonRegistrarInsumos = new JButton("Registrar Insumos");
        botonRegistrarInsumos.setBounds(20, 20, 200, 100);
        botonRegistrarInsumos.addActionListener(new eventRegistrarInsumos());
        panelBotones.add(botonRegistrarInsumos);
        
        JButton botonRegistrarProductos = new JButton("Registrar Productos");
        botonRegistrarProductos.setBounds(500, 20, 200, 100);
        botonRegistrarProductos.addActionListener(new eventRegistrarProductos());
        panelBotones.add(botonRegistrarProductos);
        
        JButton botonReabastecerInsumos = new JButton("Reabastecer Insumos");
        botonReabastecerInsumos.setBounds(260, 160, 200, 100);
        botonReabastecerInsumos.addActionListener(new eventReabastecerInsumos());
        panelBotones.add(botonReabastecerInsumos);
        
        JButton botonVerPedidos = new JButton("Ver Pedidos");
        botonVerPedidos.setBounds(20, 300, 200, 100);
        botonVerPedidos.addActionListener(new eventVerPedidos());
        panelBotones.add(botonVerPedidos);
        
        JButton botonVender = new JButton("Vender");
        botonVender.setBounds(500, 300, 200, 100);
        botonVender.addActionListener(new eventVender());
        panelBotones.add(botonVender);
        
        JPanel contenedorCarga = new JPanel();
        contenedorCarga.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton botonCargaMasivaI = new JButton("Cargar Insumos desde XML");
        botonCargaMasivaI.addActionListener(new eventCargaInsumo());
        contenedorCarga.add(botonCargaMasivaI);
        JButton botonCargaMasivaP = new JButton("Cargar Productos desde XML");
        botonCargaMasivaP.addActionListener(new eventCargaProducto());
        contenedorCarga.add(botonCargaMasivaP);
        
        
        contenedor.add(panelMostrar,BorderLayout.NORTH);
        contenedor.add(panelBotones,BorderLayout.CENTER);
        contenedor.add(contenedorCarga, BorderLayout.SOUTH);
    }
}
//Finaliza Dibujado de ventana

class eventCargaProducto implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser cargaArchivos = new JFileChooser();
        cargaArchivos.showOpenDialog(App.mainVentana);
        File file = cargaArchivos.getSelectedFile();
        App.control.getGestor().loadProductosFromXML(file.getAbsolutePath());
    }
    
}

class eventCargaInsumo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser cargaArchivos = new JFileChooser();
        cargaArchivos.showOpenDialog(App.mainVentana);
        File file = cargaArchivos.getSelectedFile();
        App.control.getGestor().getInventario().loadInsumosFromXML(file.getAbsolutePath());
    }
    
}