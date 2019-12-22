/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.dialogs;


import com.xhunik.controladores.App;
import com.xhunik.internal.ListaProducto;
import com.xhunik.vista.Ventana;
import com.xhunik.vista.VentanaVender;
import com.xhunik.vista.eventsMenu.eventBuscarProducto;
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
import javax.swing.JPanel;

/**
 *
 * @author xhunik
 */
public class DialogSearchProductos extends JDialog{

    public DialogSearchProductos() {
        super(eventRegistrarProductos.ventanaRegistro);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(260,360);
        
        Container content = getContentPane();
        
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        content.add(panelBoton,BorderLayout.SOUTH);
        
        JButton boton = new JButton("Aceptar");
        boton.addActionListener(new actionCerrarSearchProductos());
        
        panelBoton.add(boton);
        
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        content.add(panelContent,BorderLayout.CENTER);
        
        ListaProducto resultadosBusqueda = App.control.getGestor().getProductosDisponibles().searchProductosByNombre(VentanaVender.fieldBuscar.getText());
                
        for (int i = 0; i < resultadosBusqueda.getSize(); i++){
            panelContent.add(new botonProductoDialog(resultadosBusqueda.getProductoByIndex(i).getId()));
        }
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                VentanaVender.flagDialog = false;
                dispose();
            }
        });
    }
    
}

class botonProductoDialog extends JButton {
    public botonProductoDialog(int id){
        super(App.control.getGestor().getProductosDisponibles().searchProductoByID(id).getNombre());
        addActionListener(new eventoPulsarBotonDialog(id));
    }
}
class eventoPulsarBotonDialog implements ActionListener{
    int id;
    public eventoPulsarBotonDialog(int id){
        this.id = id;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        App.control.executeSellById(id);
        Ventana.cantidadGanancias.setText(String.valueOf(App.control.getDinero()));
    }
    
}

class actionCerrarSearchProductos implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        eventBuscarProducto.dialog.dispose();
        VentanaVender.flagDialog = false;
    }
    
}   