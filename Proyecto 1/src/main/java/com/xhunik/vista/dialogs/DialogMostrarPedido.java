/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.dialogs;

import com.xhunik.controladores.App;
import com.xhunik.vista.eventsMenu.eventMostrarPedidos;
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
public class DialogMostrarPedido extends JDialog {
    private int id;
    public DialogMostrarPedido(int id){
        super(eventVerPedidos.ventanaPedidos);
        this.id = id;
        
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(720,240);
        
        Container content = getContentPane();
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        content.add(panelBotones,BorderLayout.SOUTH);
        
        JButton botonAcept = new JButton("Aceptar");
        botonAcept.addActionListener(new eventAceptMostrarPedido());
        panelBotones.add(botonAcept);
        
        
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        content.add(panelContent,BorderLayout.CENTER);
        
        JPanel panelId = new JPanel();
        panelId.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelId.add(new JLabel("Id del pedido: "));
        panelId.add(new JLabel(String.valueOf(App.control.getGestor().getPedidosRealizados().searchPedidoByID(id).getId())));
        panelContent.add(panelId);
        
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelProductos.add(new JLabel("Productos Comprados: "));
        panelProductos.add(new JLabel(String.valueOf(App.control.getGestor().getPedidosRealizados().searchPedidoByID(id).getListaProductosComprados().getProductoByIndex(0))));
        panelContent.add(panelProductos);
        
        JPanel panelCosto = new JPanel();
        panelCosto.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelCosto.add(new JLabel("Precio: "));
        panelCosto.add(new JLabel(String.valueOf(App.control.getGestor().getPedidosRealizados().searchPedidoByID(id).getListaProductosComprados().getProductoByIndex(0).getPrecio())));
        panelContent.add(panelCosto);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                eventMostrarPedidos.flagDialog = false;
                dispose();
            }
        });
    }
}
class eventAceptMostrarPedido implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        eventMostrarPedidos.dialog.dispose();
        eventMostrarPedidos.flagDialog = false;
    }
    
}