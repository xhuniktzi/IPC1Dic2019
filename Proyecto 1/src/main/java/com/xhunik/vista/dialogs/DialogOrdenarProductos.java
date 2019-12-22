/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.dialogs;



import com.xhunik.vista.VentanaVender;
import com.xhunik.vista.eventsMenu.eventOrdenarProducto;
import com.xhunik.vista.eventsMenu.eventVender;

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
public class DialogOrdenarProductos extends JDialog{
    public static boolean flagOrdenamiento;
    public DialogOrdenarProductos() {
        super(eventVender.ventanaVender);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(720,240);
        
        Container content = getContentPane();
        
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        content.add(panelBoton,BorderLayout.SOUTH);
        
        JButton boton = new JButton("Aceptar");
        boton.addActionListener(new actionCerrarOrdenarProductos());
        
        panelBoton.add(boton);
        
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        content.add(panelContent,BorderLayout.CENTER);
        
        JPanel opciones1 = new JPanel();
        opciones1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelContent.add(opciones1);
        
        JButton botonBubbleAscendName = new JButton("Burbuja / A->Z");
        botonBubbleAscendName.addActionListener(new actionBurbujaAscendName());
        opciones1.add(botonBubbleAscendName);
        
        JButton botonBubbleInvName = new JButton("Burbuja / Z->A");
        botonBubbleInvName.addActionListener(new actionBurbujaInvName());
        opciones1.add(botonBubbleInvName);
        
        JButton botonSelectAscendName = new JButton("Selección / A -> Z");
        botonSelectAscendName.addActionListener(new actionSelectAscendName());
        opciones1.add(botonSelectAscendName);
        
        JButton botonSelectInvName = new JButton("Seleccion / z -> A");
        botonSelectInvName.addActionListener(new actionSelectInvName());
        opciones1.add(botonSelectInvName);
        
        JPanel opciones2 = new JPanel();
        opciones2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelContent.add(opciones2);
        
        JButton botonBubbleAscendCost = new JButton("Burbuja / Precio Ascendente");
        botonBubbleAscendCost.addActionListener(new actionBurbujaAscendCost());
        opciones2.add(botonBubbleAscendCost);
        
        JButton botonBubbleInvCost = new JButton("Burbuja / Precio Descendente");
        botonBubbleInvCost.addActionListener(new actionBurbujaInvCost());
        opciones2.add(botonBubbleInvCost);
        
        JButton botonSelectAscendCost = new JButton("Selección / Precio ascendente");
        botonSelectAscendCost.addActionListener(new actionSelectAscendCost());
        opciones2.add(botonSelectAscendCost);
        
        JButton botonSelectInvCost = new JButton("Seleccion / Precio descendente");
        botonSelectInvCost.addActionListener(new actionSelectInvCost());
        opciones2.add(botonSelectInvCost);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                VentanaVender.flagDialog2 = false;
                dispose();
            }
        });
    }
    
}
class actionCerrarOrdenarProductos implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        eventOrdenarProducto.dialog.dispose();
        VentanaVender.flagDialog2 = false;
    }
    
}

class actionBurbujaAscendCost implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!DialogOrdenarProductos.flagOrdenamiento){
            DialogProductosOrdenados dialog = new DialogProductosOrdenados(DialogProductosOrdenados.TipoOrdenamiento.BUBBLE,
                    DialogProductosOrdenados.OrdenCriterio.COSTO,
                    DialogProductosOrdenados.SentidoOrden.ASCEND);
            dialog.setVisible(true);
            DialogOrdenarProductos.flagOrdenamiento = true;
        }
    }
}

class actionBurbujaInvCost implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!DialogOrdenarProductos.flagOrdenamiento){
            DialogProductosOrdenados dialog = new DialogProductosOrdenados(DialogProductosOrdenados.TipoOrdenamiento.BUBBLE,
                    DialogProductosOrdenados.OrdenCriterio.COSTO,
                    DialogProductosOrdenados.SentidoOrden.INV);
            dialog.setVisible(true);
            DialogOrdenarProductos.flagOrdenamiento = true;
        }
    }
}

class actionBurbujaAscendName implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!DialogOrdenarProductos.flagOrdenamiento){
            DialogProductosOrdenados dialog = new DialogProductosOrdenados(DialogProductosOrdenados.TipoOrdenamiento.BUBBLE,
                    DialogProductosOrdenados.OrdenCriterio.NOMBRE,
                    DialogProductosOrdenados.SentidoOrden.ASCEND);
            dialog.setVisible(true);
            DialogOrdenarProductos.flagOrdenamiento = true;
        }
    }
}
class actionBurbujaInvName implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!DialogOrdenarProductos.flagOrdenamiento){
            DialogProductosOrdenados dialog = new DialogProductosOrdenados(DialogProductosOrdenados.TipoOrdenamiento.BUBBLE,
                    DialogProductosOrdenados.OrdenCriterio.NOMBRE,
                    DialogProductosOrdenados.SentidoOrden.INV);
            dialog.setVisible(true);
            DialogOrdenarProductos.flagOrdenamiento = true;
        }
    }
}
class actionSelectAscendCost implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!DialogOrdenarProductos.flagOrdenamiento){
            DialogProductosOrdenados dialog = new DialogProductosOrdenados(DialogProductosOrdenados.TipoOrdenamiento.SELECT,
                    DialogProductosOrdenados.OrdenCriterio.COSTO,
                    DialogProductosOrdenados.SentidoOrden.ASCEND);
            dialog.setVisible(true);
            DialogOrdenarProductos.flagOrdenamiento = true;
        }
    }
}
class actionSelectInvCost implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!DialogOrdenarProductos.flagOrdenamiento){
            DialogProductosOrdenados dialog = new DialogProductosOrdenados(DialogProductosOrdenados.TipoOrdenamiento.SELECT,
                    DialogProductosOrdenados.OrdenCriterio.COSTO,
                    DialogProductosOrdenados.SentidoOrden.INV);
            dialog.setVisible(true);
            DialogOrdenarProductos.flagOrdenamiento = true;
        }
    }
}
class actionSelectAscendName implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!DialogOrdenarProductos.flagOrdenamiento){
            DialogProductosOrdenados dialog = new DialogProductosOrdenados(DialogProductosOrdenados.TipoOrdenamiento.SELECT,
                    DialogProductosOrdenados.OrdenCriterio.NOMBRE,
                    DialogProductosOrdenados.SentidoOrden.ASCEND);
            dialog.setVisible(true);
            DialogOrdenarProductos.flagOrdenamiento = true;
        }
    }
}
class actionSelectInvName implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!DialogOrdenarProductos.flagOrdenamiento){
            DialogProductosOrdenados dialog = new DialogProductosOrdenados(DialogProductosOrdenados.TipoOrdenamiento.SELECT,
                    DialogProductosOrdenados.OrdenCriterio.COSTO,
                    DialogProductosOrdenados.SentidoOrden.ASCEND);
            dialog.setVisible(true);
            DialogOrdenarProductos.flagOrdenamiento = true;
        }
    }
}