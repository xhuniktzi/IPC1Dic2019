/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista;

import com.xhunik.controladores.App;
import static com.xhunik.vista.VentanaRegistroInsumo.fieldCantidad;
import static com.xhunik.vista.VentanaRegistroInsumo.fieldCosto;
import static com.xhunik.vista.VentanaRegistroInsumo.fieldDesc;
import static com.xhunik.vista.VentanaRegistroInsumo.fieldMaximo;
import static com.xhunik.vista.VentanaRegistroInsumo.fieldMinimo;
import static com.xhunik.vista.VentanaRegistroInsumo.fieldNombre;
import com.xhunik.vista.eventsMenu.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
public class VentanaRegistroInsumo extends JFrame{
    public static JTextField fieldNombre;
    public static JTextField fieldCantidad;
    public static JTextField fieldMaximo;
    public static JTextField fieldMinimo;
    public static JTextField fieldCosto;
    public static JTextField fieldDesc;
    public VentanaRegistroInsumo() throws HeadlessException {
        super("Registrar insumos");
        setSize(new Dimension(720,600));
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Container content = getContentPane();
        content.add(new JLabel("Registrar insumos:"),BorderLayout.NORTH);
        
        JPanel panelContent = new JPanel();
        content.add(panelContent,BorderLayout.CENTER);
        
        JPanel panelIngresoDatos = new JPanel();
        panelContent.add(panelIngresoDatos);
        panelIngresoDatos.setLayout(new BoxLayout(panelIngresoDatos, BoxLayout.Y_AXIS));
        
        JPanel panelBotones = new JPanel();
        content.add(panelBotones,BorderLayout.SOUTH);
        
        JPanel panelNombre = new JPanel();
        panelIngresoDatos.add(panelNombre);
        panelNombre.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelNombre.add(new JLabel("Nombre:"));
        fieldNombre = new JTextField(30);
        panelNombre.add(fieldNombre);
        
        JPanel panelCantidad = new JPanel();
        panelIngresoDatos.add(panelCantidad);
        panelCantidad.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelCantidad.add(new JLabel("Cantidad:"));
        fieldCantidad = new JTextField(29);
        panelCantidad.add(fieldCantidad);
        
        JPanel panelMaximo = new JPanel();
        panelIngresoDatos.add(panelMaximo);
        panelMaximo.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelMaximo.add(new JLabel("Cantidad maxima:"));
        fieldMaximo = new JTextField(24);
        panelMaximo.add(fieldMaximo);
        
        JPanel panelMinimo = new JPanel();
        panelIngresoDatos.add(panelMinimo);
        panelMinimo.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelMinimo.add(new JLabel("Cantidad minima:"));
        fieldMinimo = new JTextField(24);
        panelMinimo.add(fieldMinimo);
        
        JPanel panelCosto = new JPanel();
        panelIngresoDatos.add(panelCosto);
        panelCosto.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelCosto.add(new JLabel("Costo:"));
        fieldCosto = new JTextField(24);
        panelCosto.add(fieldCosto);
        
        JPanel panelDesc = new JPanel();
        panelIngresoDatos.add(panelDesc);
        panelDesc.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelDesc.add(new JLabel("Descripcion:"));
        fieldDesc = new JTextField(24);
        panelDesc.add(fieldDesc);
        
        
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton botonAcept = new JButton("Aceptar");
        panelBotones.add(botonAcept);
        botonAcept.addActionListener(new eventAceptar());
        JButton botonCancel = new JButton("Cancelar");
        panelBotones.add(botonCancel);
        botonCancel.addActionListener(new eventCancelar());
        
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                Ventana.flagRegistrarInsumos = false;
                dispose();
            }
        });
    }
}
class eventAceptar implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
                App.control.executeRegisterNewInsumo(fieldNombre.getText(),
                Integer.parseInt(fieldCantidad.getText()),
                Integer.parseInt(fieldMaximo.getText()),
                Integer.parseInt(fieldMinimo.getText()),
                Double.parseDouble(fieldCosto.getText()),
                fieldDesc.getText());
    }

}
class eventCancelar implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        eventRegistrarInsumos.ventanaRegistro.dispose();
        Ventana.flagRegistrarInsumos = false;
    }

}