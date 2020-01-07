/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Elements.Tablero;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author xhunik
 */
public class MostrarTabs extends JFrame{

    public MostrarTabs() {
        super("Tableros");
        setSize(800,720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container content = getContentPane();
        
        JTabbedPane pestañas = new JTabbedPane();
        
        Tablero[] tabs = App.gestor.getTableros();
        
        for (int i = 0; i < tabs.length; i++){
            pestañas.addTab(tabs[i].nombre, new PestañaTablero(tabs[i]));
        }
        
        content.add(pestañas);
    }
    
}
