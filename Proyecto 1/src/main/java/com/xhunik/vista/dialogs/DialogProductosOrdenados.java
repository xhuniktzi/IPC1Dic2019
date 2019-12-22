/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.vista.dialogs;

import com.xhunik.controladores.App;
import com.xhunik.internal.ListaProducto;
import com.xhunik.vista.Ventana;
import com.xhunik.vista.eventsMenu.eventOrdenarProducto;
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
public class DialogProductosOrdenados extends JDialog{
    public DialogProductosOrdenados(TipoOrdenamiento t, OrdenCriterio o, SentidoOrden s) {
        super(eventOrdenarProducto.dialog);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(240,360);
        
        Container content = getContentPane();
        
        JPanel panelContent = new JPanel();
        content.add(panelContent,BorderLayout.CENTER);
        
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        content.add(panelBoton,BorderLayout.SOUTH);
        
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        
        ListaProducto list = App.control.getGestor().getProductosDisponibles();
        
        if (t == TipoOrdenamiento.BUBBLE && o == OrdenCriterio.COSTO && s == SentidoOrden.ASCEND)
            list = App.control.getGestor().getProductosDisponibles().sortBurbujaAscendPrecio();
        
        if (t == TipoOrdenamiento.BUBBLE && o == OrdenCriterio.COSTO && s == SentidoOrden.INV)
            list = App.control.getGestor().getProductosDisponibles().sortBurbujaInvPrecio();
        
        if (t == TipoOrdenamiento.BUBBLE && o == OrdenCriterio.NOMBRE && s == SentidoOrden.ASCEND)
            list = App.control.getGestor().getProductosDisponibles().sortBurbujaAscendNombre();
        
        if (t == TipoOrdenamiento.BUBBLE && o == OrdenCriterio.NOMBRE && s == SentidoOrden.INV)
            list = App.control.getGestor().getProductosDisponibles().sortBurbujaInvNombre();
        
        if (t == TipoOrdenamiento.SELECT && o == OrdenCriterio.COSTO && s == SentidoOrden.ASCEND)
            list = App.control.getGestor().getProductosDisponibles().sortSelectionAscendentPrecio();
        
        if (t == TipoOrdenamiento.SELECT && o == OrdenCriterio.COSTO && s == SentidoOrden.INV)
            list = App.control.getGestor().getProductosDisponibles().sortSelectionInvPrecio();
        
        if (t == TipoOrdenamiento.SELECT && o == OrdenCriterio.NOMBRE && s == SentidoOrden.ASCEND)
            list = App.control.getGestor().getProductosDisponibles().sortSelectionAscendentAlphabet();
        
        if (t == TipoOrdenamiento.SELECT && o == OrdenCriterio.NOMBRE && s == SentidoOrden.INV)
            list = App.control.getGestor().getProductosDisponibles().sortSelectionInvAlphabet();
        
        for (int i = 0; i < list.getSize(); i++){
            panelContent.add(new botonProductoOrdenado(list.getProductoByIndex(i).getId()));
        }
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                DialogOrdenarProductos.flagOrdenamiento = false;
                dispose();
            }
        });
    }
    
    public static enum TipoOrdenamiento {
        BUBBLE,SELECT;
    }
    public static enum OrdenCriterio {
        COSTO,NOMBRE;
    }
    public static enum SentidoOrden {
        ASCEND,INV;
    }
}

class botonProductoOrdenado extends JButton {
    public botonProductoOrdenado(int id){
        super(App.control.getGestor().getProductosDisponibles().searchProductoByID(id).getNombre());
        addActionListener(new eventoPulsarBotonOrden(id));
    }
}
class eventoPulsarBotonOrden implements ActionListener{
    int id;
    public eventoPulsarBotonOrden(int id){
        this.id = id;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        App.control.executeSellById(id);
        Ventana.cantidadGanancias.setText(String.valueOf(App.control.getDinero()));
    }
    
}