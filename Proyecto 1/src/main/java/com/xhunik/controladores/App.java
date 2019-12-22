/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xhunik.controladores;

import com.xhunik.vista.Ventana;
import javax.swing.SwingUtilities;



/**
 *
 * @author xhunik
 */
public class App {
    public static PrincipalControl control;
    public static Ventana mainVentana;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         control = new PrincipalControl();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainVentana = new Ventana();
                mainVentana.setVisible(true);
            }
        });
       
        //System.out.println(gestor);
        
        
        
    }
    
}
