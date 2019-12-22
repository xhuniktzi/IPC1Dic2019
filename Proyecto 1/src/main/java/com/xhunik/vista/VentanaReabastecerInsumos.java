/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista;

import com.xhunik.controladores.App;
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
public class VentanaReabastecerInsumos extends JFrame{
    public static GridLayout cuadriculaBotones;
    public static JPanel panelMostrar;
    public VentanaReabastecerInsumos() throws HeadlessException {
        super("Reabastecer Insumos");
        setSize(new Dimension(720,600));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Container content = getContentPane();
        content.add(new JLabel("Rabastecer Insumos:"),BorderLayout.NORTH);
        JPanel panelContent = new JPanel(null);
        content.add(panelContent,BorderLayout.CENTER);
        
        int n = 0;
        while (App.control.getGestor().getInventario().getInsumosDisponibles().getSize() > (n*n)){
            n++;
        }
        
        cuadriculaBotones = new GridLayout(n,n);
        
        panelMostrar = new JPanel();
        panelMostrar.setLayout(cuadriculaBotones);
        panelMostrar.setLocation(0, 70);
        panelMostrar.setSize(500,500);
        
        
        panelContent.add(panelMostrar);
        
        
        for (int i = 0; i < App.control.getGestor().getInventario().getInsumosDisponibles().getSize(); i++){
            panelMostrar.add(new botonInsumoReabastecer(App.control.getGestor().getInventario().getInsumosDisponibles().getInsumoByIndex(i).getId()));
        }
    
        JPanel panelBotones = new JPanel();
        content.add(panelBotones,BorderLayout.SOUTH);
        
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton botonInsumos = new JButton("Reabastecer todos los Insumos");
        botonInsumos.addActionListener(new actionReabastcerTodo());
        panelBotones.add(botonInsumos);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                Ventana.flagReabastecerInsumos = false;
                dispose();
            }
        });
    }   
}
class botonInsumoReabastecer extends JButton {
    public botonInsumoReabastecer(int id){
        super(App.control.getGestor().getInventario().searchInsumoById(id).getNombre());
        addActionListener(new eventoPulsarBotonInsumoReabastecer(id));
    }
}
class eventoPulsarBotonInsumoReabastecer implements ActionListener{
    int id;
    public eventoPulsarBotonInsumoReabastecer(int id){
        this.id = id;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    App.control.executeReabastecerInsumos(id);
    //App.control.executeSellById(id);
    }
    
}
class actionReabastcerTodo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 1; i < App.control.getGestor().getInventario().getInsumosDisponibles().getSize()+1;i++){
            App.control.executeReabastecerInsumos(i);
            Ventana.cantidadGanancias.setText(String.valueOf(App.control.getDinero()));
        }
    }
    
}