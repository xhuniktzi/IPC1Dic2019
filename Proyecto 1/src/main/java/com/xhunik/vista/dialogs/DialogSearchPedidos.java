/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.dialogs;

import com.xhunik.controladores.App;
import com.xhunik.internal.ListaPedido;
import com.xhunik.internal.Pedido;
import com.xhunik.vista.VentanaVerPedidos;
import com.xhunik.vista.eventsMenu.eventBuscarPedido;
import com.xhunik.vista.eventsMenu.eventVerPedidos;
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
public class DialogSearchPedidos extends JDialog {
    public DialogSearchPedidos(){
        super(eventVerPedidos.ventanaPedidos);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(260,360);
        
        Container content = getContentPane();
        
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        content.add(panelBoton,BorderLayout.SOUTH);
        
        JButton boton = new JButton("Aceptar");
        boton.addActionListener(new actionCerrarSearchPedidos());
        
        panelBoton.add(boton);
        
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        content.add(panelContent,BorderLayout.CENTER);
        
        Pedido l = App.control.getGestor().getPedidosRealizados().searchPedidoByID(Integer.parseInt(VentanaVerPedidos.fieldBuscar.getText()));
        
        panelContent.add(new JLabel("Id: " + l.getId()));
        panelContent.add(new JLabel("Producto: " + l.getListaProductosComprados().getProductoByIndex(0).getNombre()));
        panelContent.add(new JLabel("Descripcion: " + l.getListaProductosComprados().getProductoByIndex(0).getDescripcion()));
        panelContent.add(new JLabel("Precio: " + l.getListaProductosComprados().getProductoByIndex(0).getPrecio()));
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                VentanaVerPedidos.flagDialog2 = false;
                dispose();
            }
        });
    }
    
}
class actionCerrarSearchPedidos implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        eventBuscarPedido.dialog.dispose();
        VentanaVerPedidos.flagDialog2 = false;
    }
    
}