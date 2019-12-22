/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.dialogs;


import com.xhunik.controladores.App;
import com.xhunik.internal.ListaInsumo;
import com.xhunik.vista.VentanaRegistroProducto;
import com.xhunik.vista.eventsMenu.eventBuscarInsumo;
import com.xhunik.vista.eventsMenu.eventRegistrarProductos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author xhunik
 */
public class DialogSearchInsumos extends JDialog{

    public DialogSearchInsumos() {
        super(eventRegistrarProductos.ventanaRegistro);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(300,300);
        
        Container content = getContentPane();
        
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        content.add(panelBoton,BorderLayout.SOUTH);
        
        JButton boton = new JButton("Aceptar");
        boton.addActionListener(new actionCerrarSearchInsumos());
        
        panelBoton.add(boton);
        
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        content.add(panelContent,BorderLayout.CENTER);
        
        ListaInsumo resultadosBusqueda = App.control.getGestor().getInventario().getInsumosDisponibles().searchInsumosByNombre(VentanaRegistroProducto.fieldBuscar.getText());
                
        for (int i = 0; i < resultadosBusqueda.getSize(); i++){
            panelContent.add(new JLabel("Producto: " + resultadosBusqueda.getInsumoByIndex(i).getNombre()));
        }
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                VentanaRegistroProducto.flagDialog = false;
                dispose();
            }
        });
    }
    
}



class actionCerrarSearchInsumos implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        eventBuscarInsumo.dialog.dispose();
        VentanaRegistroProducto.flagDialog = false;
    }
    
}
