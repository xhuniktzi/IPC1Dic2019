/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista;


import com.xhunik.controladores.App;
import com.xhunik.internal.ListaInsumo;
import com.xhunik.vista.eventsMenu.eventBuscarInsumo;

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
public class VentanaRegistroProducto extends JFrame{
    public static boolean flagDialog;
    public static JTextField fieldBuscar;
    public static GridLayout cuadriculaBotones;
    public static JPanel panelMostrar;
    public static JTextField fieldNombre;
    public static JTextField fieldCosto;
    public static JTextField fieldDesc;
    public static ListaInsumo insumosAdded;
    public VentanaRegistroProducto() throws HeadlessException {
        super("Registrar Producto");
        setSize(new Dimension(720,600));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Container content = getContentPane();
        content.add(new JLabel("Registrar productos:"),BorderLayout.NORTH);
        JPanel panelContent = new JPanel(null);
        content.add(panelContent,BorderLayout.CENTER);

        insumosAdded = App.control.getGestor().getInventario().getInsumosDisponibles().copiaListaInsumo();
        
        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSearch.setLocation(0,0);
        panelSearch.setSize(700,50);
        panelContent.add(panelSearch);
        
        
        
        panelSearch.add(new JLabel("Buscar:"));
        fieldBuscar = new JTextField(30);
        panelSearch.add(fieldBuscar);
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(new eventBuscarInsumo());
        panelSearch.add(botonBuscar);
        
        int n = 0;
        while (App.control.getGestor().getInventario().getInsumosDisponibles().getSize() > (n*n)){
            n++;
        }
        
        cuadriculaBotones = new GridLayout(n,n);
        
        panelMostrar = new JPanel();
        panelMostrar.setLayout(cuadriculaBotones);
        panelMostrar.setLocation(0, 70);
        panelMostrar.setSize(400,400);
        
        
        panelContent.add(panelMostrar);
        
        
        for (int i = 0; i < App.control.getGestor().getInventario().getInsumosDisponibles().getSize(); i++){
            panelMostrar.add(new botonInsumo(App.control.getGestor().getInventario().getInsumosDisponibles().getInsumoByIndex(i).getId()));
        }
        
        JPanel panelIngresoDatos = new JPanel();
        panelIngresoDatos.setLocation(400, 80);
        panelIngresoDatos.setSize(280,480);
        panelContent.add(panelIngresoDatos);
        panelIngresoDatos.setLayout(new BoxLayout(panelIngresoDatos, BoxLayout.Y_AXIS));
        
        JPanel panelNombre = new JPanel();
        panelIngresoDatos.add(panelNombre);
        panelNombre.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelNombre.add(new JLabel("Nombre:"));
        fieldNombre = new JTextField(20);
        panelNombre.add(fieldNombre);
        
        JPanel panelCosto = new JPanel();
        panelIngresoDatos.add(panelCosto);
        panelCosto.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelCosto.add(new JLabel("Costo:"));
        fieldCosto = new JTextField(12);
        panelCosto.add(fieldCosto);
        
        JPanel panelDesc = new JPanel();
        panelIngresoDatos.add(panelDesc);
        panelDesc.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelDesc.add(new JLabel("Descripcion:"));
        fieldDesc = new JTextField(18);
        panelDesc.add(fieldDesc);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                Ventana.flagRegistrarProductos = false;
                dispose();
            }
        });
    }
    
}
class botonInsumo extends JButton {
    public botonInsumo(int id){
        super(App.control.getGestor().getInventario().searchInsumoById(id).getNombre());
        addActionListener(new eventoPulsarBotonInsumo(id));
    }
}
class eventoPulsarBotonInsumo implements ActionListener{
    
    int id;
    public eventoPulsarBotonInsumo(int id){
        this.id = id;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        /*
        insumoTemp.setCantidad(App.control.getGestor().getInventario().getInsumosDisponibles().searchInsumoByID(id).getId());
        insumoTemp.setFlag(true);
        insumoTemp.setCantidad(VentanaRegistroProducto.datoCantidad);
        //VentanaRegistroProducto.insumosAdded.addInsumo(insumoTemp);
        */
        /*
        for (int i = 0; i < VentanaRegistroProducto.insumosAdded.getSize();i++){
            if (VentanaRegistroProducto.insumosAdded.getInsumoByIndex(i).getId() == id){
                VentanaRegistroProducto.insumosAdded.getInsumoByIndex(i).setCantidad(VentanaRegistroProducto.datoCantidad);
            }
        }
        System.out.println(VentanaRegistroProducto.insumosAdded);
        */
    //App.control.executeSellById(id);
    }
    
}
/*
                App.control.executeRegisterNuevoProducto(VentanaRegistroProducto.fieldNombre.getText(),
                VentanaRegistroProducto.insumosAdded,
                Double.parseDouble(VentanaRegistroProducto.fieldCosto.getText()),
                VentanaRegistroProducto.fieldDesc.getText());
*/
